package com.example.apixml

data class MyDataItem(
  //  val barcodeData: String,
    val barcodeData: List<String>,
    val orderno: Int,
    val _id: String,
    val BatchID: String,
    val Title: String,
    val date: String,
    val count: Int,

)