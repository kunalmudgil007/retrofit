package com.example.apixml

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

const val BASE_URL ="https://nodei.ssccglpinnacle.com/"
class MainActivity : AppCompatActivity() {

    private lateinit var txtId: TextView//


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getMyData()


        txtId = findViewById(R.id.txtId) //


    }

    private fun getMyData() {
       val retrofitBuilder = Retrofit.Builder()
           .addConverterFactory(GsonConverterFactory.create())
           .baseUrl(BASE_URL)
           .build()
           .create(ApiInterface::class.java)

        val retrofitData=retrofitBuilder.getData()
        retrofitData.enqueue(object : Callback<List<MyDataItem>?> {



//            override fun onResponse(
//                call: Call<List<MyDataItem>?>,
//                response: Response<List<MyDataItem>?>
//            ) {
//
//                val responseBody=response.body()!!
//                val myStringBuilder =StringBuilder()
//                for (myData in responseBody){
//                  //  myStringBuilder.append(myData.distributorName)// replace id
//                    myStringBuilder.append(myData.Title)
//                    myStringBuilder.append(myData._id)
//
//                    myStringBuilder.append(myData.date)
//
//                    myStringBuilder.append("\n")
//
//
//                }
//               txtId.text = myStringBuilder
//
//
//            }




            override fun onResponse(
                call: Call<List<MyDataItem>?>,
                response: Response<List<MyDataItem>?>
            ) {
                if (response.isSuccessful) {
                    val responseBody = response.body()!!
                    val myStringBuilder = StringBuilder()

                    // Search criteria
                    //val searchTitle = "STATIC GK Theory+MCQ Chapterwise"



//
                     val searchbarcodeData = "R-222-2-1888"


                      for (myData in responseBody) {


                        //if (myData.barcodeData == searchbarcode) {
                            if (myData.barcodeData.contains(searchbarcodeData)) {


                            myStringBuilder.append("Title: ${myData.Title}\n\n")
                            myStringBuilder.append("Id: ${myData._id}\n\n")
                            myStringBuilder.append("Date: ${myData.date}\n\n")
                            myStringBuilder.append("BatchID: ${myData.BatchID}\n\n")

                            myStringBuilder.append("Count: ${myData.count}\n\n")
                            myStringBuilder.append("Orderno: ${myData.orderno}\n\n")


                            myStringBuilder.append("BarcodeData: ${myData.barcodeData}\n\n")



                        }
                    }







//                    for (myData in responseBody) {
//                        if (myData.Title == searchTitle) {
//                            myStringBuilder.append("Title: ${myData.Title}\n\n")
//                            myStringBuilder.append("Id: ${myData._id}\n\n")
//                            myStringBuilder.append("Date: ${myData.date}\n\n")
//                            myStringBuilder.append("BatchID: ${myData.BatchID}\n\n")
//
//                            myStringBuilder.append("Count: ${myData.count}\n\n")
//                            myStringBuilder.append("Orderno: ${myData.orderno}\n\n")
//
//
//                            myStringBuilder.append("BarcodeData: ${myData.barcodeData}\n\n")
//
//
//
//                        }
//                    }

                    txtId.text = myStringBuilder.toString()
                } else {
                    Log.e("MainActivity", "onResponse: ${response.code()}")
                }
            }


            override fun onFailure(call: Call<List<MyDataItem>?>, t: Throwable) {
                Log.d("MainActivity","onFailure:"+t.message)
            }
        })
    }
}


