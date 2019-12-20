$(function () {

});

function toShopCart() {
  var name=$(".name").val();
  var img="";
  var count=$(".count").val();
  var price=$(".price").val();
  $.ajax({
    url : "toShopCar",
    type : "post",
    dataType : "json",
    data : {
      name:name,
      img : img,
      count:count,
      price:price
    },
    success : function(data) {
      alert(data);
    }
  });
}