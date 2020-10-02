package to.msn.wings.ourmenu

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        registerForContextMenu(menuImage) //menuImageを長押ししたらonCreateContextMenu()メソッドが呼び出される
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        if (menuText.text.isNotEmpty()) {
            menuInflater.inflate(R.menu.context,menu)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean { //メニュー表示
        menuInflater.inflate(R.menu.main,menu)
        return true
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item?.itemId) {
            R.id.mail -> {
                val subject = getString(R.string.app_name)
                val text = "I want to eat ${menuText.text}!!"
                val uri = Uri.fromParts("mailto","daiyanokado898@gmail.com",null)
                val intent = Intent(Intent.ACTION_SENDTO,uri)
                intent.putExtra(Intent.EXTRA_SUBJECT,subject)
                intent.putExtra(Intent.EXTRA_TEXT,text)
                if (intent.resolveActivity(packageManager) != null) {
                    startActivity(intent)
                }
                    return true
            }
            R.id.sms -> {
                val text = "I want to eat ${menuText.text}!!"
                val uri = Uri.fromParts("smsto","9999999999999", null)
                val intent = Intent(Intent.ACTION_SENDTO, uri)
                intent.putExtra("sms_body", text)
                if (intent.resolveActivity(packageManager) != null) {
                    startActivity(intent)
                }
                    return true
            }
        }
        return super.onContextItemSelected(item)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item?.itemId) {
            R.id.home -> {
                menuImage.setImageResource(R.drawable.hungryyy)
                menuText.text = ""
                return true
            }
            R.id.maguroDon -> {
                menuImage.setImageResource(R.drawable.maguro_don)
                menuText.text = getString(R.string.magurodon_text)
                return true
            }
            R.id.katsudon -> {
                menuImage.setImageResource(R.drawable.katsudon)
                menuText.text = getString(R.string.katsudon_text)
                return true
            }
            R.id.CurryRice -> {
                menuImage.setImageResource(R.drawable.curry_rice)
                menuText.text = getString(R.string.curry_rice_tetx)
                return true
            }
            R.id.CurryLunch -> {
                menuImage.setImageResource(R.drawable.curry)
                menuText.text = getString(R.string.curry_lunch_text)
                return true
            }
            R.id.pizza -> {
                menuImage.setImageResource(R.drawable.pizza)
                menuText.text = getString(R.string.pizza_text)
                return true
            }
            R.id.steakBento -> {
                menuImage.setImageResource(R.drawable.stake_bentou)
                menuText.text = getString(R.string.stake_bento_text)
                return true
            }
            R.id.hinomaruBento -> {
                menuImage.setImageResource(R.drawable.hinomaru_bentou)
                menuText.text = getString(R.string.hinomaru_bento_text)
                return true
            }
            R.id.takeruBento -> {
                menuImage.setImageResource(R.drawable.takeru_bentou)
                menuText.text = getString(R.string.takeru_bento_text)
                return true
            }
            R.id.kaisenLunch -> {
                menuImage.setImageResource(R.drawable.kaisen_lunch)
                menuText.text = getString(R.string.kaisen_lunch_text)
                return true
            }
            R.id.kidsLunch -> {
                menuImage.setImageResource(R.drawable.kids_lunch_big)
                menuText.text = getString(R.string.kids_lunch_big_etxt)
                return true
            }
            R.id.yasaiLunch -> {
                menuImage.setImageResource(R.drawable.yasai_lunch)
                menuText.text = getString(R.string.yasai_lunch_text)
                return true
            }
            R.id.shogayaki -> {
                menuImage.setImageResource(R.drawable.shogayaki)
                menuText.text = getString(R.string.shogayaki)
                return true
            }
            R.id.omuHayashi -> {
                menuImage.setImageResource(R.drawable.omu_hayashi_raisu)
                menuText.text = getString(R.string.omu_hayashi_text)
                return true
            }
            R.id.saladPlate -> {
                menuImage.setImageResource(R.drawable.sarada_plate)
                menuText.text = getString(R.string.sarad_plate_text)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
