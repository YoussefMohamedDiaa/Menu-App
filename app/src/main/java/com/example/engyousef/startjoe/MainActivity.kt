package com.example.engyousef.startjoe

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.food_ticket.view.*

class MainActivity : AppCompatActivity() {

    var foodlist = ArrayList<food>()
    var foodadapter:foodAdpater?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //load food
        foodlist.add(food("Coffe","coffe is a morning drink",R.drawable.coffee_pot))
        foodlist.add(food("Esperso","Esperso contain alot of kaffien",R.drawable.espresso))
        foodlist.add(food("French fries","French fries is junk food",R.drawable.french_fries))
        foodlist.add(food("Honey","Honey comes from bees",R.drawable.honey))
        foodlist.add(food("Strawbary","Strawbary is winter fruit",R.drawable.strawberry_ice_cream))
        foodlist.add(food("Suger cubes","Suger cubes is used in Tea",R.drawable.sugar_cubes))

       foodadapter= foodAdpater(this,foodlist)

        gridViewList.adapter =foodadapter
    }

    class foodAdpater: BaseAdapter{
        var listOfFood = ArrayList<food>()
        var context:Context?=null
        constructor(context: Context,listOfFood:ArrayList<food>):super(){
             this.context=context
             this.listOfFood=listOfFood
        }
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val food = listOfFood[position]
            var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var foodView = inflator.inflate(R.layout.food_ticket,null)
            foodView.ivFoodimage.setImageResource(food.image!!)
            foodView.ivFoodimage.setOnClickListener{
                val intent = Intent(context,fooddetails::class.java)
                intent.putExtra("name",food.name!!)
                intent.putExtra("des",food.des!!)
                intent.putExtra("image",food.image!!)
                context!!.startActivity(intent)
            }
            foodView.tvName.text=food.name!!
            return foodView


        }

        override fun getItem(position: Int): Any {
            return listOfFood[position]
        }

        override fun getItemId(position: Int): Long {
           return position.toLong()
        }

        override fun getCount(): Int {
            return listOfFood.size
        }

    }
}
