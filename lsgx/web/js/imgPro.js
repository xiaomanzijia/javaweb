/**
 * 校验是否为图片文件格式
 * @returns {Boolean}
 */
function checkPic() {
	var picPath = document.getElementById("picPath").value;
	var type = picPath.substring(picPath.lastIndexOf(".") + 1, picPath.length)
			.toLowerCase();
	if (type != "jpg" && type != "bmp" && type != "gif" && type != "png") {
		alert("***请上传正确的图片格式");
		return false;
	}
	return true;
	
}

/**
 * 图片预览
 */
function PreviewImage2222(divImage, upload, width, height) {
	if (checkPic()) {
		var imgPath;
		//图片路径     
		var Browser_Agent = navigator.userAgent;
		var objPreviewFake = document.getElementById('Preview');
		var objPreviewSizeFake = document.getElementById('preview_size_fake');
		//判断浏览器的类型   
		if (Browser_Agent.indexOf("Firefox") != -1) {
			//火狐浏览器
			imgPath = window.URL.createObjectURL(upload.files[0]);
//			$("#"+divImage).append("<img id='imgPreview' src='"	+ imgPath+ "' onload=\"img(this)\"/>");
			var thisImg = $(upload);
			thisImg.closest('div').parent().find('.Preview').html("<img id='' src='"
					+ imgPath+ "' onload=\"img(this)\"/>") ;
		
		} else {
			//IE浏览器
		}
	}
}
    
/**
 * 图片缩小
 */
function img(upload,proMaxWidth,proMaxHeight){
	var image=new Image();
	image=upload;
	image.onload = function(){
		if(image.width>0&&image.height>0)
		{	
			var width=image.width;
			var height=image.height;
			var rate;
			if(image.width>image.height){
				rate=proMaxWidth/image.width;
			}else{
				rate=proMaxHeight/image.height;
			}
			if(rate<=1)
			{
				upload.width=width*rate;
				upload.height=rate*height;
				
			}
			else
			{
				upload.width=image.width;
				upload.height=image.height;
			}
			
			w=upload.width;
			h=upload.height
			$("div.Preview").css("width",w);
			$("div.Preview").css("height",h);
			$("div.view").css("width",w);
			$("div.view").css("height",h);
		}
	};
	image.onload();
}

/**
 * 详情显示中长宽压缩图片
 * @param  proMaxWidth 图片最大宽度
 * @param  proMaxHeight 图片最大高度
 */
function ImgAuto(ImgD,proMaxWidth,proMaxHeight)
{
var image=new Image();
image.src=ImgD.src;

image.onload = function(){
if(image.width>0&&image.height>0)
{
var rate=(proMaxWidth/image.width<proMaxHeight/image.height)?proMaxWidth/image.width:proMaxHeight/image.height;
if(rate<=1)
{
	
ImgD.width=image.width*rate;
ImgD.height=image.height*rate
}
else
{
ImgD.width=image.width;
ImgD.height=image.height;
}
}
};
image.onload();
};

/**
 * 获取图片坐标
 */
function i_imageAreaSelect(width,height) {
    $("div.Preview").imgAreaSelect({
	aspectRatio: ''+width+':'+height+'', 
	handles: true,
    onSelectEnd: function (img, selection) {
    	$("div.Preview").parent().find("[name='x1']").val(selection.x1);
    	$("div.Preview").parent().find("[name='y1']").val(selection.y1);
        $("div.Preview").parent().find("[name='x2']").val(selection.x2);
        $("div.Preview").parent().find("[name='y2']").val(selection.y2);
        }
    });
}

function deleleDiv(){
	$(".imgareaselect-selection").parent().remove();
	$(".imgareaselect-outer").remove();
}

/**
 * 预览
 * @param sender
 * @returns {Boolean}
 */
function PreviewImage(sender,width,height)
{
    if (!sender.value.match(/.jpg|.gif|.png|.bmp/i)) //忽略大小写
    {
        alert('图片格式无效！');
        return false;
    }
    var objPreviewSizeFake = document.getElementById('preview_size_fake');
    var objPreviewFake = document.getElementById('Preview');
    if (sender.files && sender.files[0])
    {
    	 // 火狐        
    	var imgPath = window.URL.createObjectURL(sender.files[0]);
		var thisImg = $(sender);
		if(width!=null&&width!=''){
			thisImg.closest('div').parent().find('.Preview').html("<img id='' src='"
				+ imgPath+ "' onload=\"img(this,"+width +","+height+")\"/>") ;
		}else{
			thisImg.closest('div').parent().find('.Preview').html("<img id='' src='"
					+ imgPath+ "' onload=\"img(this,300,350)\"/>") ;
		}
    }
    
    else if (objPreviewFake.filters)
    {
     // IE
       sender.select();
       sender.blur();  
       objPreviewSizeFake.style.width  =   "1px";  
       objPreviewSizeFake.style.height  =   "1px" ;
       var imgSrc = document.selection.createRange().text;
       document.selection.empty();  
       objPreviewSizeFake.style.filter="progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod='image',src='"+imgSrc+"')";  
       objPreviewFake.style.width  =   "1px";  
       objPreviewFake.style.height  =   "1px" ;
       setTimeout(function(){autoSizePreview(width,height,objPreviewFake,objPreviewSizeFake)},100);
       setTimeout(function(){objPreviewFake.filters.item('DXImageTransform.Microsoft.AlphaImageLoader').src = imgSrc;},100);
       
    }
}


//赋给div压缩后图片的长宽
function autoSizePreview(width,height,objPre,objSize)
{	
	var zoomParam ='';
	if(width!=null&&width!=''){
	    zoomParam = clacImgZoomParam(width, height, objSize.offsetWidth, objSize.offsetHeight);	
	}else{
		zoomParam = clacImgZoomParam(300, 350, objSize.offsetWidth, objSize.offsetHeight);	
	}
    objPre.style.width = zoomParam.width + 'px';
    objPre.style.height = zoomParam.height + 'px';
    objSize.style.width="0px";
    objSize.style.height="0px";
}
//图片压缩方法
function clacImgZoomParam(maxWidth, maxHeight, width, height)
{ 
//	alert(maxWidth+"        "+maxHeight+"    "+width+"  "+height)
    var param = { width: width, height: height, top: 0, left: 0};
    if(width>0&&height>0)
	{	
		var rate;
		if(width>height){
			rate=maxWidth/width;
		}else{
			rate=maxHeight/height;
		}
		if(rate<=1)
		{
			param.width=width*rate;
			param.height=rate*height;
			
		}
		else
		{
			param.width=width;
			param.height=height;
		}
	}
    return param;
}       

function imgUpload_dialogAjaxDone(json){
	DWZ.ajaxDone(json);
	 if (json.statusCode == DWZ.statusCode.ok){
         if (json.navTabId){ //把指定navTab页面标记为需要“重新载入”。注意navTabId不能是当前navTab页面的
        	 deleleDiv();
        	 navTab.reloadFlag(json.navTabId);
         } 
         if ("closeCurrent" == json.callbackType) {
             $.pdialog.close('upload_img');
         } 
      }
}
/**
 * 关闭按钮绑定清除截图选择区域
 */
$(document).ready(function () {
	$('a.close',$.pdialog.getCurrent()).bind('click',function(){
		deleleDiv();
	});
});