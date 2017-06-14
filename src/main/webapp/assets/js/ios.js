// Make all links open within the same 'instance' so that iOS doesn't open new Safari windows
var a=document.getElementsByTagName("a");
for(var i=0;i<a.length;i++)
{
    a[i].onclick=function()
    {
        window.location=this.getAttribute("href");
        return false
    }
}

// Grow the map, shrink the map
$('body').on('click','.map img',function(e){
    if ( $(this).parent().hasClass('inactive') ) {
        $(this).parent().removeClass('inactive').addClass('active');
    } else {
        $(this).parent().removeClass('active').addClass('inactive');
    }
});