package com.example.permissionx

import android.Manifest.permission.CALL_PHONE
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.permissionx.jiahangdev.PermissionX
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        PermissionX.request(this,CALL_PHONE){allGranted,deniedList->
            if(allGranted){
                call()
            }
            else{
                Toast.makeText(this,"授权失败",Toast.LENGTH_SHORT).show()
            }
        }
    }
    fun call(){
        val intent= Intent(Intent.ACTION_CALL)
        intent.data= Uri.parse("tel:15626234174")
        startActivity(intent)
    }
}
