package kim.hsl.nav

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation.findNavController
import androidx.navigation.ui.NavigationUI

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // fragmentContainerView 组件的 管理 操作通过 NavController 完成
        // 对应的就是 navController 实例变量
        val navController = findNavController(this, R.id.fragment)
        NavigationUI.setupActionBarWithNavController(this, navController)

        //NavigationUI.setup
    }
}