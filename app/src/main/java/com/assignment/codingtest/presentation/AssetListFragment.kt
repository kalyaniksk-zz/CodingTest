package com.assignment.codingtest.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.assignment.codingtest.data.Model.Asset
import com.assignment.codingtest.data.Model.AssetList
import com.assignment.codingtest.R
import com.assignment.codingtest.Usescase.ErrorResponse
import com.assignment.codingtest.Usescase.Response
import com.assignment.codingtest.Usescase.SuccessResponse
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_asset_list.*
import javax.inject.Inject


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class AssetListFragment : DaggerFragment(), RecycleViewAdapter.OnItemClickListener {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: AssetViewModel
    private lateinit var sortedAssetList :List<Asset>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_asset_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(AssetViewModel::class.java)
        loadData()
    }

    private fun loadData() {
        viewModel.run {
            getCountryDetailsObservable().observe(
                viewLifecycleOwner,
                Observer<Response<AssetList, Throwable>> { response ->
                    when (response) {
                        is SuccessResponse -> {
                            progressBar.visibility = View.GONE
                            if(response.data.displayName != null) {
                                (activity as MainActivity?)?.supportActionBar?.setTitle(response.data.displayName)
                            }
                            assetDetailsRecycleView.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
                            if(response.data.assets != null) {
                                val assetList = response.data.assets as ArrayList<Asset>
                                /* sorted the Asset list in descending
                                * */
                                sortedAssetList = assetList.sortedByDescending { asset: Asset -> asset.timeStamp }
                                val adapter = RecycleViewAdapter(sortedAssetList, this@AssetListFragment)
                                assetDetailsRecycleView.adapter = adapter
                            }
                            else{
                                showToast("List is empty")
                            }

                        }
                        is ErrorResponse -> {
                            progressBar.visibility = View.GONE
                            showToast(response.errorData?.message.toString())

                        }
                    }
                })
        }
    }

    override fun onClick(view: View?, position: Int) {
        /* recycle view item click send url to WebViewFragment
        * */
        val action = AssetListFragmentDirections.actionFirstFragmentToSecondFragment(sortedAssetList.get(position).url)
        findNavController().navigate(action)
    }
    private fun showToast(message : String){
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
    }
}