package kim.hsl.app2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI

class MainActivity : AppCompatActivity() {

    lateinit var navController: NavController
    lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. 获取 NavController
        navController = Navigation.findNavController(this, R.id.fragmentContainerView)

        // 2. 创建 AppBarConfiguration
        appBarConfiguration = AppBarConfiguration.Builder(navController.graph).build()

        // 3. 将 Navigation 导航 与 AppBar 进行关联
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)

        // 4. 监听页面切换状态
        navController.addOnDestinationChangedListener{
                /*
                    相当于重写了下面的函数
                    public fun onDestinationChanged(
                        controller: NavController,
                        destination: NavDestination,
                        arguments: Bundle?)
                 */
                navController: NavController, navDestination: NavDestination, bundle: Bundle? ->
                Log.i("octopus", "OnDestinationChangedListener 监听器中 onDestinationChanged 函数触发")
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        // 加载资源文件中的菜单
        // 只加载菜单 , 此时不能跳转 , 需要重写 onOptionsItemSelected 方法才可以
        menuInflater.inflate(R.menu.my_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // 重写了该方法 , 菜单选项才能生效
        // 优先使用 NavigationUI 进行导航 , 如果跳转失败 , 再使用传统的方式
        return NavigationUI.onNavDestinationSelected(item, navController)
                || super.onOptionsItemSelected(item)
    }

    // 默认状态下进入 FragmentB 后是无法返回的
    // 如果想要返回, 需要重写 onSupportNavigateUp 方法
    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}