$(function () {
  //页面加载执行
  showTotalPrice();
})

function showTotalPrice() {
  var total="";

  $.ajax({
    url:"showTotalPrice",
    type:"post",
    dataType:"text",
    success: function(data) {
      // for (var i=0;i<data.length;i++){
      //   var book=data[i];
      //   total+=book.totalPrice;
      // }
      total=data;
      var content='<a href="/saveAddMessage?totalPrice='+data+'">结算</a>';
      $("#checkout").html(content);
      $("#total").html(total);
    },
  });

}