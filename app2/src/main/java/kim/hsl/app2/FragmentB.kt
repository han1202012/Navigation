package kim.hsl.app2

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment

class FragmentB : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // 确保 onCreateOptionsMenu 函数执行
        setHasOptionsMenu(true)
        // 为 Fragment 加载布局
        return inflater.inflate(R.layout.fragment_b, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        // 清空菜单
        menu.clear()
        super.onCreateOptionsMenu(menu, inflater)
    }
}