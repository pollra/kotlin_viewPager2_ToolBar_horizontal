package com.example.viewpager2andtabbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViewPager2()
        setSupportActionBar(toolbar)

        // toolbar 를 리스너 연결
        toolbar.setNavigationOnClickListener {
            Toast.makeText(this, "Navigation Menu Clicked", Toast.LENGTH_SHORT).show()
        }
    }

    // 메뉴 등록
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.mainmenu, menu)
        return true
    }

    // menu icon 눌렀을 때의 동작 구현
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var itemview = item.itemId
        when(itemview) {
            R.id.search_go_btn -> Toast.makeText(applicationContext, "Search Clicked", Toast.LENGTH_SHORT).show()
        }
        return false
    }

    private fun initViewPager2() {
        // ViewPager initialization
        var viewPager: ViewPager2 = findViewById(R.id.viewpager)
        var adapter = ViewPagerViewAdapter()
        viewPager.adapter = adapter
        adapter.setNewUsers(createExampleUserList())

        var tabLayout: TabLayout = findViewById(R.id.tablayout)
        TabLayoutMediator(tabLayout, viewPager) {tab, position ->
            tab.text = createExampleUserList() [position].name
        }.attach()
    }

    private fun createExampleUserList() : ArrayList<User> {
        var export:ArrayList<User> = ArrayList()
        export.add(User("인기", "Freeman"))
        export.add(User("최신", "Bowman"))
        export.add(User("보관함", "Freeman"))
        return export
    }
}