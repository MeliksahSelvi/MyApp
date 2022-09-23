function addComment() {

    var name = $('#name').val();
    var content = $('#content').val();
    $.ajax({
        url: 'http://localhost:8080/MyApp/CommentServlet',
        method: 'POST',
        data: {name: name, content: content}
    });
}
$(document).ready(
    $.ajax({
        url :'http://localhost:8080/MyApp/CommentServlet',
        method: 'GET',
        success : function (data) {
            var temp=JSON.parse(data);
            for(var i=0;i<temp.length;i++){
                const kutu=document.createElement("div");
                const isim=document.createElement("h1");
                const yorum=document.createElement("p");
                const satir=document.createElement("br");

                isim.innerText=temp[i].name;
                yorum.innerText=temp[i].content;

                kutu.appendChild(isim);
                kutu.appendChild(satir);
                kutu.appendChild(yorum);
                kutu.style.cssFloat="left";
                kutu.style.marginRight="30px";
                document.getElementById("comments").appendChild(kutu);
            }
        }
    })
);

