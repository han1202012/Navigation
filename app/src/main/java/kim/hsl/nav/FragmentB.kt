package kim.hsl.nav

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation

// 定义 Kotlin 常量
private const val ARG_PARAM_NAME = "NAME"
private const val ARG_PARAM_AGE = "AGE"

class FragmentB : Fragment() {
    private var name: String? = null
    private var age: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            name = it.getString(ARG_PARAM_NAME)
            age = it.getInt(ARG_PARAM_AGE)
        }

        Log.i("TAG", "FragmentA 传递到 FragmentB 的参数为 name = $name , age = $age")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // 设置 Fragment 布局文件
        return inflater.inflate(R.layout.fragment_b, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button = view.findViewById<Button>(R.id.button)
        button.setOnClickListener {
            var args: Bundle = FragmentBArgs.Builder()
                                            .setNAME("Trump")
                                            .setAGE(80)
                                            .build().toBundle()

            // 获取 NavigationController
            val navController = Navigation.findNavController(it)
            // 按照 action_fragmentB_to_fragmentA 对应的 action 的导航路线走
            navController.navigate(R.id.action_fragmentB_to_fragmentA, args)
        }
    }
}