<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport">
	<title>移动端图片压缩上传demo</title>
	<style>
		*{margin: 0;padding: 0;}
		li{list-style-type: none;}
		a,input{outline: none;-webkit-tap-highlight-color:rgba(0,0,0,0);}
		#choose{display: none;}
		canvas{width: 100%;border: 1px solid #000000;}
		#upload{display: block;margin: 10px;height: 60px;text-align: center;line-height: 60px;border: 1px solid;border-radius: 5px;cursor: pointer;}
		.touch{background-color: #ddd;}
		.img-list{margin: 10px 5px;}
		.img-list li{position: relative;display: inline-block;width: 100px;height: 100px;margin: 5px 5px 20px 5px;border: 1px solid rgb(100,149,198);background: #fff no-repeat center;background-size: cover;}
		.progress{position: absolute;width: 100%;height: 20px;line-height: 20px;bottom: 0;left: 0;background-color:rgba(100,149,198,.5);}
		.progress span{display: block;width: 0;height: 100%;background-color:rgb(100,149,198);text-align: center;color: #FFF;font-size: 13px;}
		.size{position: absolute;width: 100%;height: 15px;line-height: 15px;bottom: -18px;text-align: center;font-size: 13px;color: #666;}
		.tips{display: block;text-align:center;font-size: 13px;margin: 10px;color: #999;}
		.pic-list{margin: 10px;line-height: 18px;font-size: 13px;}
		.pic-list a{display: block;margin: 10px 0;}
		.pic-list a img{
			vertical-align: middle;
			max-width: 30px;
			max-height: 30px;
			margin: -4px 0 0 10px;
		}
	</style>
</head>
<body>
<input type="file" id="choose" accept="image/*" multiple>
<ul class="img-list">
	<!--<li style="background-image:url('/public/upload/upload.jpeg')">-->
	<!--<div class="progress"><span style="width: 100%">上传成功</span></div>-->
	<!--<div class="size">100KB</div>-->
	<!--</li>-->
</ul>
<a id="upload">上传图片</a>
<span class="tips">只允许上传jpg、png及gif</span>

<div class="pic-list">
	你上传的图片(图片有效期为1分钟)：
</div>

<script src="/ui/js/jquery-2.1.1.min.js"></script>
<script>
	var filechooser = document.getElementById("choose");
	//    用于压缩图片的canvas
	var canvas = document.createElement("canvas");
	var ctx = canvas.getContext('2d');
	//    瓦片canvas
	var tCanvas = document.createElement("canvas");
	var tctx = tCanvas.getContext("2d");
	var maxsize = 100 * 1024;
	$("#upload").on("click", function () {
		filechooser.click();
	})
			.on("touchstart", function () {
				$(this).addClass("touch")
			})
			.on("touchend", function () {
				$(this).removeClass("touch")
			});
	filechooser.onchange = function () {
		if (!this.files.length) return;
		var files = Array.prototype.slice.call(this.files);
		if (files.length > 9) {
			alert("最多同时只可上传9张图片");
			return;
		}
		files.forEach(function (file, i) {
			if (!/\/(?:jpeg|png|gif)/i.test(file.type)) return;
			var reader = new FileReader();
			var li = document.createElement("li");
//          获取图片大小
			var size = file.size/1024 > 1024 ? (~~(10*file.size/1024/1024))/10 + "MB" :  ~~(file.size/1024) + "KB";
			li.innerHTML = '<div class="progress"><span></span></div><div class="size">'+size+'</div>';
			$(".img-list").append($(li));
			reader.onload = function () {
				var result = this.result;
				var img = new Image();
				img.src = result;
				$(li).css("background-image", "url(" + result + ")");
				//如果图片大小小于100kb，则直接上传
				if (result.length <= maxsize) {
					img = null;
					upload(result, file.type, $(li));
					return;
				}
//                图片加载完毕之后进行压缩，然后上传
				if (img.complete) {
					callback();
				} else {
					img.onload = callback;
				}
				function callback() {
					var data = compress(img);
					upload(data, file.type, $(li));
					img = null;
				}
			};
			reader.readAsDataURL(file);
		})
	};
	//    使用canvas对大图片进行压缩
	function compress(img) {
		var initSize = img.src.length;
		var width = img.width;
		var height = img.height;
		//如果图片大于四百万像素，计算压缩比并将大小压至400万以下
		var ratio;
		if ((ratio = width * height / 4000000)>1) {
			ratio = Math.sqrt(ratio);
			width /= ratio;
			height /= ratio;
		}else {
			ratio = 1;
		}
		canvas.width = width;
		canvas.height = height;
//        铺底色
		ctx.fillStyle = "#fff";
		ctx.fillRect(0, 0, canvas.width, canvas.height);
		//如果图片像素大于100万则使用瓦片绘制
		var count;
		if ((count = width * height / 1000000) > 1) {
			count = ~~(Math.sqrt(count)+1); //计算要分成多少块瓦片
//            计算每块瓦片的宽和高
			var nw = ~~(width / count);
			var nh = ~~(height / count);
			tCanvas.width = nw;
			tCanvas.height = nh;
			for (var i = 0; i < count; i++) {
				for (var j = 0; j < count; j++) {
					tctx.drawImage(img, i * nw * ratio, j * nh * ratio, nw * ratio, nh * ratio, 0, 0, nw, nh);
					ctx.drawImage(tCanvas, i * nw, j * nh, nw, nh);
				}
			}
		} else {
			ctx.drawImage(img, 0, 0, width, height);
		}
		//进行最小压缩
		var ndata = canvas.toDataURL('image/jpeg', 0.1);
		console.log('压缩前：' + initSize);
		console.log('压缩后：' + ndata.length);
		console.log('压缩率：' + ~~(100 * (initSize - ndata.length) / initSize) + "%");
		tCanvas.width = tCanvas.height = canvas.width = canvas.height = 0;
		return ndata;
	}
	//    图片上传，将base64的图片转成二进制对象，塞进formdata上传
	function upload(basestr, type, $li) {
		var text = window.atob(basestr.split(",")[1]);
		var buffer = new Uint8Array(text.length);
		var pecent = 0 , loop = null;
		for (var i = 0; i < text.length; i++) {
			buffer[i] = text.charCodeAt(i);
		}
		var blob = getBlob(buffer, type);
		var xhr = new XMLHttpRequest();
		var formdata = new FormData();
		formdata.append('imagefile', blob);
		xhr.open('post', '/h5img/uploadImgAjax.do');
		xhr.onreadystatechange = function () {
			if (xhr.readyState == 4 && xhr.status == 200) {
				var jsonData = JSON.parse(xhr.responseText);
				console.log('上传成功：' + jsonData.path);
				clearInterval(loop);
				//当收到该消息时上传完毕
				$li.find(".progress span").animate({'width': "100%"}, pecent < 95 ? 200 : 0, function () {
					$(this).html("上传成功");
				});
				$(".pic-list").append('<a href="' + jsonData.path + '">' +jsonData.path + '（' + jsonData.size+'）<img src="' + jsonData.path + '" /></a>');
			}
		};
		//数据发送进度，前50%展示该进度
		xhr.upload.addEventListener('progress', function (e) {
			if (loop) return;
			pecent = ~~(100 * e.loaded / e.total) / 2;
			$li.find(".progress span").css('width', pecent + "%");
			if (pecent == 50) {
				mockProgress();
			}
		}, false);
		//数据后50%用模拟进度
		function mockProgress() {
			if (loop) return;
			loop = setInterval(function () {
				pecent++;
				$li.find(".progress span").css('width', pecent + "%");
				if (pecent == 99) {
					clearInterval(loop);
				}
			}, 100)
		}
		xhr.send(formdata);
	}
	// 获取blob对象的兼容性写法
	function getBlob(buffer, format){
		var Builder = window.WebKitBlobBuilder || window.MozBlobBuilder;
		if(Builder){
			var builder = new Builder;
			builder.append(buffer);
			return builder.getBlob(format);
		} else {
			return new window.Blob([ buffer ], {type: format});
		}
	}
</script>
</body>
</html>
