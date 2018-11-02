package org.smwu.smwuandroid.ui.login

import android.content.Intent
import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Base64
import android.util.Log
import com.kakao.auth.AuthType
import com.kakao.auth.Session
import kotlinx.android.synthetic.main.activity_login.*
import org.smwu.smwuandroid.ui.main.MainActivity
import smwu.com.smwuandroid.R
import org.smwu.smwuandroid.util.SessionCallback
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        getHashkey()

        kakao_login_btn.setOnClickListener {
            val session = Session.getCurrentSession()
            session.addCallback(SessionCallback(this))
            session.open(AuthType.KAKAO_ACCOUNT,this)
//            val intent = Intent(applicationContext, MainActivity::class.java)
//            startActivity(intent)
        }
    }

    fun getHashkey(){

        try{

            val info = getPackageManager().getPackageInfo("org.smwu.smwuandroid", PackageManager.GET_SIGNATURES)

            for(signature in info.signatures){
                val md = MessageDigest.getInstance("SHA")
                md.update(signature.toByteArray())
                Log.d("TAG: ","key_hash: "+ Base64.encodeToString(md.digest(),Base64.DEFAULT))
            }

        } catch (e : PackageManager.NameNotFoundException){
            e.printStackTrace()
        } catch (e:NoSuchAlgorithmException){
            e.printStackTrace()
        }

    }

}
