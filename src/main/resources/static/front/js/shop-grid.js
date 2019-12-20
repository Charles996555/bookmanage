$(function() {
  show(1);
  // showbooktype();
  $("#prepage").click(function(){
    //当前页
    var currentpage=parseInt($("#currentpage").html());
    var type000=$("#booktype000").val();
    var type=$("#type2").val();
    if(type=='y'){
      if(currentpage>1){
        showByFind(currentpage-1,type000);
      }
    }else {
      if(currentpage>1){
        show(currentpage-1);
      }
    }
  });
  $("#nextpage").click(function(){
    //总页数
    var totalpage=parseInt($("#totalpage").html());
    var currentpage=parseInt($("#currentpage").html());
    var type000=$("#booktype000").val();
    var type=$("#type2").val();
    if(type=='y'){
      if(currentpage<totalpage){
        showByFind(currentpage+1,type000);
      }
    }else{
      if(currentpage<totalpage){
        show(currentpage+1);
      }
    }

  });

  // $("#find1").click(function(){
  //   showByFind(1);
  // });

});
function showByFind(ppage,findtype){
  $.ajax({
    url : "showByFindBookType",
    type : "post",
    dataType : "json",
    data : {
      findType:findtype,
      page : ppage
    },
    success : function(data) {
      var content = "";
      var currentpage = data.currentPage;
      var totalpage = data.totalPage;
      var books = data.books;
      // var isSearch=data.isSearch;
      content+='<input type="text"  value="y" id="type2" style="display: none">'
      for (var i = 0; i < books.length; i++) {
        var po = books[i];

        content +='<div class="col-lg-4 col-md-4 col-sm-6 col-12">'
            +'<div class="product">'
            +'<div class="product__thumb">'
            +'<a class="first__img" href="toSingleProduct?id='+po.id+'"><img src="'+po.img+'" alt="product image"></a>'
            +'<ul class="prize position__right__bottom d-flex">'
            +'<li>'+po.price+'</li>'
            +'</ul>'
            +'<div class="action">'
            +'<div class="actions_inner">'
            +'</div>'
            +'</div>'
            +'</div>'
            +'<div class="product__content">'
            +'<h4><a href="toSingleProduct?id='+po.id+'">'+po.name+'</a></h4>'
            +'</div>'
            +'</div>'
            +'</div>'
      }
      $("#booklist").html(content);
      $("#currentpage").html(currentpage);
      $("#totalpage").html(totalpage);
      $("#booktype000").val(findtype);
    }
  });
}
function showbooktype() {
  //显示分类信息
  $.ajax({
    url:"showBookType",
    type:"post",
    datatype:"json",
    data:{

    },
    success:function (booktype) {
     var content="";
     for (var i=0;i<booktype.length;i++){
       var po=booktype[i];
       content +='<li><a>'+po.typename+' <span>('+po.count+')</span></a><div style="display: none" class="booktypeid">'+po.id+'</div></li>'
     };
      $("#booktypeul").html(content);
    }
  })
}
function show(ppage) {
  //分页显示全部书籍
  $.ajax({
    url : "showBooks",
    type : "post",
    dataType : "json",
    data : {
      // goodstypeid : $("#goodstypeid").val(),
      page : ppage
    },
    success : function(data) {
      var content = "";
      var currentpage = data.currentPage;
      var totalpage = data.totalPage;
      var books = data.books;
      // var isSearch=data.isSearch;
      content+='<input type="text"  value="n" id="type2" style="display: none">'
      for (var i = 0; i < books.length; i++) {
        var po = books[i];

        content +='<div class="col-lg-4 col-md-4 col-sm-6 col-12">'
            +'<div class="product">'
            +'<div class="product__thumb">'
            +'<a class="first__img" href="toSingleProduct?id='+po.id+'"><img src="'+po.img+'" alt="product image"></a>'
            +'<ul class="prize position__right__bottom d-flex">'
            +'<li>'+po.price+'</li>'
            +'</ul>'
            +'<div class="action">'
            +'<div class="actions_inner">'
            +'</div>'
            +'</div>'
            +'</div>'
            +'<div class="product__content">'
            +'<h4><a href="toSingleProduct?id='+po.id+'">'+po.name+'</a></h4>'
            +'</div>'
            +'</div>'
            +'</div>'
      }
      $("#booklist").html(content);
      $("#currentpage").html(currentpage);
      $("#totalpage").html(totalpage);
    }
  });
}