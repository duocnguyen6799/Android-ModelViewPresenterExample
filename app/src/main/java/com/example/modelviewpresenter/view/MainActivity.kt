package com.example.modelviewpresenter.view

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.modelviewpresenter.R
import com.example.modelviewpresenter.presenter.MainActivityPresenter

/* MODEL VIEW PRESENTER
   - PRESENTER: là lớp trung gian có thể giao tiếp được với 2 lớp Model & View (M-V không thể giao tiếp với nhau)
        + nhận event từ view do người dùng tương tác
        + truyền dữ liệu từ present sang view để display
   - MODEL: dữ liệu được đưa vào model rồi đẩy sang presenter thông qua các hàm callback
 */

class MainActivity : AppCompatActivity(), MainActivityPresenter.View {
    var edtUsername:EditText?=null
    var edtFullname:EditText?=null
    var txtInfo:TextView?=null
    var presenter:MainActivityPresenter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = MainActivityPresenter(this)
        edtFullname = findViewById(R.id.edtFullname)
        edtUsername = findViewById(R.id.edtUsername)
        txtInfo = findViewById(R.id.txtInfo)
        edtUsername?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                presenter?.updateUsername(s.toString())
            }
            override fun afterTextChanged(s: Editable) {
            }
        })
        edtFullname?.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                presenter?.updateFullname(s.toString())
            }
            override fun afterTextChanged(s: Editable?) {

            }
        })
    }

    override fun updateInfoUser(info: String) {
        txtInfo?.setText(info)
    }
}