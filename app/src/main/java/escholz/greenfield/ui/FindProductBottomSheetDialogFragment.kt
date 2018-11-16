package escholz.greenfield.ui

import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.textfield.TextInputEditText
import dagger.android.support.AndroidSupportInjection
import escholz.greenfield.R
import javax.inject.Inject

class FindProductBottomSheetDialogFragment
    @Inject
    constructor()
: BottomSheetDialogFragment(), AdapterView.OnItemSelectedListener {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: FindProductViewModel

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.find_product_layout, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(FindProductViewModel::class.java)
        viewModel.identifierType.observe(viewLifecycleOwner, Observer {
            view?.findViewById<TextView>(R.id.identifier_type_label)?.text = it
        })
        viewModel.identifierTypeHint.observe(viewLifecycleOwner, Observer {
            view?.findViewById<TextInputEditText>(R.id.search_input_edit_text)?.hint = it
        })

        view?.findViewById<Button>(R.id.search_button)?.setOnClickListener { viewModel.search() }

        val spinner = view?.findViewById<Spinner>(R.id.identifier_type)
        spinner?.adapter = ArrayAdapter<String>(activity!!, R.layout.product_identifier_type_layout, viewModel.identifierTypes())
        spinner?.onItemSelectedListener = this
    }

    override fun onCancel(dialog: DialogInterface?) {
        super.onCancel(dialog)
    }

    override fun onDismiss(dialog: DialogInterface?) {
        super.onDismiss(dialog)
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        viewModel.setIdentifierType(viewModel.identifierTypes()[0])
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        viewModel.setIdentifierType(viewModel.identifierTypes()[position])
    }
}