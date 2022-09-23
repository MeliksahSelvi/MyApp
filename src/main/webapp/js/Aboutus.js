function sendComment() {
    // jquery.get isteği
  var name=$('#name').val();
  var comment=$('#comment').val();
  $.ajax({
      url   :'http://localhost:8080/MyApp/ContentServlet',
      method :'POST',
      data :{name:name,comment:comment}
  });
}

$(document).ready(
    $.ajax({
        url :'http://localhost:8080/MyApp/ContentServlet',
        method: 'GET',
        success : function (data) {
            var temp=JSON.parse(data);
            for(var i=0;i<temp.length;i++){
                const kutu=document.createElement("div");
                const baslik=document.createElement("h1");
                const metin=document.createElement("p");
                const satir=document.createElement("br");

                baslik.innerText=temp[i].head;
                metin.innerText=temp[i].content;

                kutu.appendChild(baslik);
                kutu.appendChild(satir);
                kutu.appendChild(metin);
                document.getElementById("maincontent").appendChild(kutu);
            }
        }
    })
);
