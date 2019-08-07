var loadTime = 0
	, mjkf = {
	mindaibasedomain: "mindai.com",
	AK: "00000001",
	AKS: "A1B2C3D4E5F60708",
	requestUrl: "//bank.mindai.com/api",
	requestUrlHD: "//bank.mindai.com/hd",
	oldUrl: "http://www.mindai.com",
	dtssTip: "系统升级中，请稍后再访问。",
	reg: {
		phone: /^1[3|4|5|6|7|8|9][0-9]\d{8,8}$/
	},
	scrollNotice: function(e) {
		var t = $(e);
		t.find(".realText").css("paddingRight", 80);
		var r = t.html()
			, n = t.find(".realText").width() + 80
			, i = this;
		return this.timer = null,
			this.move = function() {
				var e = t.attr("data-nowLeft");
				void 0 === e && (e = 0),
					e--,
				Math.abs(e) >= n && (e = 0),
					t.css({
						"-webkit-transform": "translateX(" + e + "px)",
						"-moz-transform": "translateX(" + e + "px)",
						"-ms-transform": "translateX(" + e + "px)",
						"-o-transform": "translateX(" + e + "px)",
						transform: "translateX(" + e + "px)"
					}),
					t.attr("data-nowLeft", e)
			}
			,
		n >= .8 * t.parents(".noticeContent").width() && t.html(r + r),
			this.start = function() {
				if (n < .8 * t.parents(".noticeContent").width())
					return !1;
				clearInterval(i.timer),
					i.timer = setInterval(function() {
						i.move()
					}, 50)
			}
			,
			this.stop = function() {
				clearInterval(i.timer)
			}
			,
			setTimeout(this.start, 2e3),
			{
				start: this.start,
				stop: this.stop
			}
	},
	pageIsShowing: function(e, t) {
		var r = "hidden"in document ? "hidden" : "webkitHidden"in document ? "webkitHidden" : "mozHidden"in document ? "mozHidden" : null
			, n = r.replace(/hidden/i, "visibilitychange")
			, i = function() {
			var n = new Date;
			n.getHours() > 9 ? n.getHours() : n.getHours(),
				n.getMinutes() > 9 ? n.getMinutes() : n.getMinutes(),
				n.getSeconds() > 9 ? n.getSeconds() : n.getSeconds(),
				document[r] ? t && t() : e && e()
		};
		document.addEventListener(n, i)
	},
	riskCheck: function(e) {
		var t = mjkf.getLocalStorage("sessionId")
			, r = {
			deviceType: "pc"
		};
		mjkf.ajax("user.investorAccount", "1.0", r, t, function(t) {
			if ("0000" === t.code) {
				var r = t.data
					, n = {
					method: "user.myInfo",
					version: "1.0",
					sessionId: mjkf.getLocalStorage("sessionId"),
					bizContent: {
						deviceType: "pc"
					}
				};
				mjkf.ajax(n.method, n.version, n.bizContent, n.sessionId, function(t) {
					if ("0000" === t.code) {
						var n = t.data
							, i = localStorage.getItem("riskAssessmentCGType");
						parseFloat(e.amount) + parseFloat(r.reclaimPrincipal) > parseFloat(n.maxInvestAmount) && i !== t.data.riskAssessmentCGType ? (localStorage.setItem("riskAssessmentCGType", t.data.riskAssessmentCGType),
						e && e.riskCallback && e.riskCallback(n, r)) : e && e.investCallback && e.investCallback()
					}
				}, null, 0)
			}
		})
	},
	getShareLink: function(e) {
		//var t = sessionStorage.getItem("oldUserId") || "";
		return window.location.href.indexOf("testbank") >= 0 ? "weixin" === e ? "http://mtest4.mindaitianxia.com/reg!regpage.action?user_inviteid=" + mjkf.Base64.encode(t).replace(/[\s]*/g, "") + "&keycode=invited" : "http://test4.mindaitianxia.com/reg!regpage.action?user_inviteid=" + mjkf.Base64.encode(t).replace(/[\s]*/g, "") + "&keycode=invited" : window.location.href.indexOf("192.168") >= 0 ? "weixin" === e ? "http://mtest4.mindaitianxia.com/reg!regpage.action?user_inviteid=" + mjkf.Base64.encode(t).replace(/[\s]*/g, "") + "&keycode=invited" : "http://test4.mindaitianxia.com/reg!regpage.action?user_inviteid=" + mjkf.Base64.encode(t).replace(/[\s]*/g, "") + "&keycode=invited" : "weixin" === e ? "https://m.mindai.com/reg!regpage.action?user_inviteid=" + mjkf.Base64.encode(t).replace(/[\s]*/g, "") + "&keycode=invited" : "https://www.mindai.com/reg!regpage.action?user_inviteid=" + mjkf.Base64.encode(t).replace(/[\s]*/g, "") + "&keycode=invited"
	},
	aesEncrypt: function(e, t, r) {
		var n = CryptoJS.enc.Utf8.parse(e)
			, i = CryptoJS.enc.Utf8.parse(t)
			, o = CryptoJS.enc.Utf8.parse(r)
			, s = CryptoJS.AES.encrypt(n, i, {
			iv: o,
			mode: CryptoJS.mode.CBC,
			padding: CryptoJS.pad.Pkcs7
		});
		return CryptoJS.enc.Base64.stringify(s.ciphertext)
	},
	Base64: function() {
		function e() {
			this._keyStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/="
		}
		return e.prototype.encode = function(e) {
			var t, r, n, i, o, s, a, c = "", f = 0;
			for (e = this._utf8_encode(e); f < e.length; )
				t = e.charCodeAt(f++),
					r = e.charCodeAt(f++),
					n = e.charCodeAt(f++),
					i = t >> 2,
					o = (3 & t) << 4 | r >> 4,
					s = (15 & r) << 2 | n >> 6,
					a = 63 & n,
					isNaN(r) ? s = a = 64 : isNaN(n) && (a = 64),
					c = c + this._keyStr.charAt(i) + this._keyStr.charAt(o) + this._keyStr.charAt(s) + this._keyStr.charAt(a);
			return c
		}
			,
			e.prototype.decode = function(e) {
				var t, r, n, i, o, s, a, c = "", f = 0;
				for (e = e.replace(/[^A-Za-z0-9\+\/\=]/g, ""); f < e.length; )
					i = this._keyStr.indexOf(e.charAt(f++)),
						o = this._keyStr.indexOf(e.charAt(f++)),
						s = this._keyStr.indexOf(e.charAt(f++)),
						a = this._keyStr.indexOf(e.charAt(f++)),
						t = i << 2 | o >> 4,
						r = (15 & o) << 4 | s >> 2,
						n = (3 & s) << 6 | a,
						c += String.fromCharCode(t),
					64 != s && (c += String.fromCharCode(r)),
					64 != a && (c += String.fromCharCode(n));
				return c = this._utf8_decode(c)
			}
			,
			e.prototype._utf8_encode = function(e) {
				e = e.replace(/\r\n/g, "\n");
				for (var t = "", r = 0; r < e.length; r++) {
					var n = e.charCodeAt(r);
					n < 128 ? t += String.fromCharCode(n) : n > 127 && n < 2048 ? (t += String.fromCharCode(n >> 6 | 192),
						t += String.fromCharCode(63 & n | 128)) : (t += String.fromCharCode(n >> 12 | 224),
						t += String.fromCharCode(n >> 6 & 63 | 128),
						t += String.fromCharCode(63 & n | 128))
				}
				return t
			}
			,
			e.prototype._utf8_decode = function(e) {
				for (var t = "", r = 0, n = 0, i = 0, o = 0; r < e.length; )
					n = e.charCodeAt(r),
						n < 128 ? (t += String.fromCharCode(n),
							r++) : n > 191 && n < 224 ? (i = e.charCodeAt(r + 1),
							t += String.fromCharCode((31 & n) << 6 | 63 & i),
							r += 2) : (i = e.charCodeAt(r + 1),
							o = e.charCodeAt(r + 2),
							t += String.fromCharCode((15 & n) << 12 | (63 & i) << 6 | 63 & o),
							r += 3);
				return t
			}
			,
			new e
	}(),
	getDAesString: function(e, t, r) {
		var n = CryptoJS.enc.Utf8.parse(t)
			, i = CryptoJS.enc.Utf8.parse(r);
		return CryptoJS.AES.decrypt(e, n, {
			iv: i,
			mode: CryptoJS.mode.CBC,
			padding: CryptoJS.pad.Pkcs7
		}).toString(CryptoJS.enc.Utf8)
	},
	setSessionStorage: function(e, t) {
		// sessionStorage.setItem(e, t)
	},
	getSessionStorage: function(e) {
		// return sessionStorage.getItem(e)
	},
	removeSessionStorage: function(e) {
		// return sessionStorage.removeItem(e)
	},
	clearSessionStorage: function() {
		// return sessionStorage.clear()
	},
	setLocalStorage: function(e, t) {
		// sessionStorage.setItem(e, t)
	},
	getLocalStorage: function(e) {
		// return sessionStorage.getItem(e)
	},
	removeLocalStorage: function(e) {
		// return sessionStorage.removeItem(e)
	},
	clearLocalStorage: function() {
		// return sessionStorage.clear()
	},
	getBJTime: function() {
		var e = new Date
			, t = e.getTime() + 6e4 * e.getTimezoneOffset()
			, r = new Date(t + 288e5)
			, n = "yyyy-MM-dd hh:mm:ss"
			, i = {
			"M+": r.getMonth() + 1,
			"d+": r.getDate(),
			"h+": r.getHours(),
			"m+": r.getMinutes(),
			"s+": r.getSeconds(),
			"q+": Math.floor((r.getMonth() + 3) / 3),
			S: r.getMilliseconds()
		};
		/(y+)/.test(n) && (n = n.replace(RegExp.$1, (r.getFullYear() + "").substr(4 - RegExp.$1.length)));
		for (var o in i)
			new RegExp("(" + o + ")").test(n) && (n = n.replace(RegExp.$1, 1 == RegExp.$1.length ? i[o] : ("00" + i[o]).substr(("" + i[o]).length)));
		return n
	},
	activityajax: function(e) {
		e.body.bizContent.deviceType = e.body.bizContent.deviceType || "pc";
		var t = mjkf.getLocalStorage("sessionId") || e.body.sessionId
			, r = JSON.stringify(e.body.bizContent)
			, r = mjkf.aesEncrypt(r, mjkf.AKS, mjkf.AKS)
			, n = mjkf.getBJTime()
			, i = mjkf.AKS + "appKey" + mjkf.AK + "bizContent" + r + "formatjsonlocalecnmethod" + e.body.method + "sessionId" + t + "timestamp" + n + "v" + e.body.version + mjkf.AKS
			, o = CryptoJS.SHA1(i).toString().toUpperCase();
		$.ajax({
			type: "post",
			url: e.url || mjkf.requestUrl,
			data: {
				method: e.body.method,
				appKey: mjkf.AK,
				v: e.body.version,
				format: "json",
				locale: "cn",
				sessionId: t,
				timestamp: n,
				bizContent: r,
				sign: o
			},
			dataType: "json",
			timeout: e.timeout || 3e4,
			success: function(t) {
				0 === e.noReturn ? "function" == typeof e.success && e.success(t) : (removeLoading(),
					"21" == t.code ? (logout(),
						mjkf.clearLocalStorage(),
						window.location.href = "login.html") : "25" == t.code ? _alert("sign错误，请刷新重试") : "function" == typeof e.success && e.success(t))
			},
			error: function(t, r, n) {
				$("#loading").remove(),
				"function" == typeof e.error && e.error(t, r, n)
			},
			complete: function(e, t) {
				"timeout" == t && (_alert("网络开小差，请稍后再试..."),
					$("#loading").remove())
			}
		})
	},
	ajax: function(e, t, r, n, i, o, s, a) {
		r.deviceType = r.deviceType || "pc";
		var n = mjkf.getLocalStorage("sessionId") || n
			, r = JSON.stringify(r)
			, r = mjkf.aesEncrypt(r, mjkf.AKS, mjkf.AKS)
			, c = mjkf.getBJTime()
			, f = mjkf.AKS + "appKey" + mjkf.AK + "bizContent" + r + "formatjsonlocalecnmethod" + e + "sessionId" + n + "timestamp" + c + "v" + t + mjkf.AKS
			, u = CryptoJS.SHA1(f).toString().toUpperCase();
		$.ajax({
			type: "post",
			url: mjkf.requestUrl,
			data: {
				method: e,
				appKey: mjkf.AK,
				v: t,
				format: "json",
				locale: "cn",
				sessionId: n,
				timestamp: c,
				bizContent: r,
				sign: u
			},
			dataType: "json",
			timeout: a || 3e4,
			success: function(e) {
				0 === s ? "function" == typeof i && i(e) : "21" == e.code ? (logout(),
					mjkf.clearLocalStorage(),
					window.location.href = "login.html") : "25" == e.code ? _alert("sign错误，请刷新重试") : "function" == typeof i && i(e)
			},
			error: function(t, r, n) {
				$("#loading").remove(),
				(e.indexOf("user.withdraw") > -1 || e.indexOf("user.recharge") > -1) && _alert("操作处理中，请15分钟后在交易记录中查询！"),
				"function" == typeof o && o(t, r, n)
			},
			complete: function(e, t) {
				"timeout" == t && (_alert("网络开小差，请稍后再试..."),
					$("#loading").remove())
			}
		})
	},
	projectStatus: function(e) {
		var t = "";
		switch (Number(e)) {
			case 1:
				t = "筹款中";
				break;
			case 2:
				t = "还款中";
				break;
			case 3:
				t = "已还清";
				break;
			case 4:
				t = "已满标";
				break;
			case 5:
				t = "流标";
				break;
			case 6:
				t = "逾期中";
				break;
			case 7:
				t = "筹款期满"
		}
		return t
	},
	bankCode: function(e) {
		var t = "";
		return e.indexOf("工商") > -1 ? t = "bank-icbc" : e.indexOf("建设") > -1 ? t = "bank-ccb" : e.indexOf("招商") > -1 ? t = "bank-cmb" : e.indexOf("中国银行") > -1 ? t = "bank-boc" : e.indexOf("农业") > -1 ? t = "bank-abc" : e.indexOf("平安") > -1 ? t = "bank-pab" : e.indexOf("广发") > -1 ? t = "bank-cgb" : e.indexOf("民生") > -1 ? t = "bank-cmbc" : e.indexOf("浦发") > -1 ? t = "bank-spdb" : e.indexOf("光大") > -1 ? t = "bank-ceb" : e.indexOf("渤海") > -1 ? t = "bank-cbhb" : e.indexOf("邮政存储") > -1 ? t = "bank-post" : e.indexOf("华夏") > -1 ? t = "bank-hxb" : e.indexOf("中信") > -1 ? t = "bank-citic" : e.indexOf("北京银行") > -1 ? t = "bank-bob" : e.indexOf("交通") > -1 ? t = "bank-bcm" : e.indexOf("兴业") > -1 && (t = "bank-cib"),
			t
	},
	verifyPhone: function(e) {
		return e ? 11 != e.length ? "手机号码格式错误" : mjkf.reg.phone.test(e) ? 1 : "手机号码格式错误" : "请输入手机号码"
	},
	verifyUserName: function(e) {
		var t = /^[0-9A-Za-z_]{1,20}$/;
		return e ? e.length > 20 ? "手机号或用户名格式错误" : t.test(e) ? 1 : "手机号或用户名格式错误" : "请输入手机号或用户名"
	},
	verifyPassword: function(e) {
		var t = /^[~`!@#\$%\^&\*\(\)_\-\+=\|\\\}\]\{\[:;<,>\.\?\/"'a-zA-Z0-9]{6,32}$/;
		return e ? e.length < 6 || e.length > 32 ? "请输入6-32位数字、字母组成的密码" : t.test(e) ? 1 : "请输入6-32位数字、字母组成的密码" : "请输入密码"
	},
	verifyRegPassword: function(e) {
		var t = /(?!^[0-9]+$)(?!^[A-z]+$)(?!^[~`!@#\$%\^&\*\(\)_\-\+=\|\\\}\]\{\[:;<,>\.\?\/"']+$)(?!^[^A-z0-9]+$)^.{6,32}$/;
		return e ? e.length < 6 || e.length > 32 ? "请输入6-32位数字、字母组成的密码" : t.test(e) ? 1 : "请输入由字母、数字、符号组成的密码" : "请设置登录密码"
	},
	getQueryString: function(e) {
		var t = new RegExp("(^|&)" + e + "=([^&]*)(&|$)","i")
			, r = window.location.search.substr(1).match(t);
		return null != r ? unescape(r[2]) : null
	},
	moneyFormat: function(e) {
		var e = e;
		return "number" != typeof e && "string" != typeof e ? e : (e = e.toString(),
			e = e.split("").reverse().join(""),
			e = e.replace(/(\d{3})/g, "$1,"),
			e = e.split("").reverse().join(""),
		0 == e.indexOf(",") && (e = e.replace(/,/, "")),
			e)
	},
	numFormatCn: function(e) {
		if ("number" != typeof e)
			return e;
		switch (e) {
			case 1:
				e = "一";
				break;
			case 2:
				e = "二";
				break;
			case 3:
				e = "三";
				break;
			case 4:
				e = "四";
				break;
			case 5:
				e = "五";
				break;
			case 6:
				e = "六";
				break;
			case 7:
				e = "七";
				break;
			case 8:
				e = "八";
				break;
			case 9:
				e = "九";
				break;
			case 10:
				e = "十";
				break;
			case 11:
				e = "十一";
				break;
			case 12:
				e = "十二";
				break;
			case 13:
				e = "十三";
				break;
			case 14:
				e = "十四";
				break;
			case 15:
				e = "十五";
				break;
			case 16:
				e = "十六";
				break;
			case 17:
				e = "十七";
				break;
			case 18:
				e = "十八";
				break;
			case 19:
				e = "十九";
				break;
			case 20:
				e = "二十"
		}
		return e
	},
	getLocalStorageForUser: function() {
		// var e = mjkf.getLocalStorage("isDepository")
		// 	, t = mjkf.getLocalStorage("entityType")
		// 	, r = (mjkf.getLocalStorage("userType"),
		// 	mjkf.getLocalStorage("userName"));
		// 2 == t ? $(".depository-bar").hide() : 0 == e && 1 == t ? ($(".depository-bar").show(),
		// 	$(".status").attr("class", "status status-no").html("未开通存管")) : 1 == e && 1 == t && ($(".depository-bar").hide(),
		// 	$(".status").attr("class", "status status-yes").html("已开通存管")),
		// 	$(".user-name").html(r)
	}
};
mjkf.getLocalStorageForUser(),
	Date.prototype.format = function(e) {
		var t = {
			"M+": this.getMonth() + 1,
			"d+": this.getDate(),
			"h+": this.getHours(),
			"m+": this.getMinutes(),
			"s+": this.getSeconds(),
			"q+": Math.floor((this.getMonth() + 3) / 3),
			S: this.getMilliseconds()
		};
		/(y+)/.test(e) && (e = e.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length)));
		for (var r in t)
			new RegExp("(" + r + ")").test(e) && (e = e.replace(RegExp.$1, 1 == RegExp.$1.length ? t[r] : ("00" + t[r]).substr(("" + t[r]).length)));
		return e
	}
;
var CryptoJS = CryptoJS || function(e, t) {
	var r = {}
		, n = r.lib = {}
		, i = function() {}
		, o = n.Base = {
		extend: function(e) {
			i.prototype = this;
			var t = new i;
			return e && t.mixIn(e),
			t.hasOwnProperty("init") || (t.init = function() {
					t.$super.init.apply(this, arguments)
				}
			),
				t.init.prototype = t,
				t.$super = this,
				t
		},
		create: function() {
			var e = this.extend();
			return e.init.apply(e, arguments),
				e
		},
		init: function() {},
		mixIn: function(e) {
			for (var t in e)
				e.hasOwnProperty(t) && (this[t] = e[t]);
			e.hasOwnProperty("toString") && (this.toString = e.toString)
		},
		clone: function() {
			return this.init.prototype.extend(this)
		}
	}
		, s = n.WordArray = o.extend({
		init: function(e, t) {
			e = this.words = e || [],
				this.sigBytes = void 0 != t ? t : 4 * e.length
		},
		toString: function(e) {
			return (e || c).stringify(this)
		},
		concat: function(e) {
			var t = this.words
				, r = e.words
				, n = this.sigBytes;
			if (e = e.sigBytes,
					this.clamp(),
				n % 4)
				for (var i = 0; i < e; i++)
					t[n + i >>> 2] |= (r[i >>> 2] >>> 24 - i % 4 * 8 & 255) << 24 - (n + i) % 4 * 8;
			else if (65535 < r.length)
				for (i = 0; i < e; i += 4)
					t[n + i >>> 2] = r[i >>> 2];
			else
				t.push.apply(t, r);
			return this.sigBytes += e,
				this
		},
		clamp: function() {
			var t = this.words
				, r = this.sigBytes;
			t[r >>> 2] &= 4294967295 << 32 - r % 4 * 8,
				t.length = e.ceil(r / 4)
		},
		clone: function() {
			var e = o.clone.call(this);
			return e.words = this.words.slice(0),
				e
		},
		random: function(t) {
			for (var r = [], n = 0; n < t; n += 4)
				r.push(4294967296 * e.random() | 0);
			return new s.init(r,t)
		}
	})
		, a = r.enc = {}
		, c = a.Hex = {
		stringify: function(e) {
			var t = e.words;
			e = e.sigBytes;
			for (var r = [], n = 0; n < e; n++) {
				var i = t[n >>> 2] >>> 24 - n % 4 * 8 & 255;
				r.push((i >>> 4).toString(16)),
					r.push((15 & i).toString(16))
			}
			return r.join("")
		},
		parse: function(e) {
			for (var t = e.length, r = [], n = 0; n < t; n += 2)
				r[n >>> 3] |= parseInt(e.substr(n, 2), 16) << 24 - n % 8 * 4;
			return new s.init(r,t / 2)
		}
	}
		, f = a.Latin1 = {
		stringify: function(e) {
			var t = e.words;
			e = e.sigBytes;
			for (var r = [], n = 0; n < e; n++)
				r.push(String.fromCharCode(t[n >>> 2] >>> 24 - n % 4 * 8 & 255));
			return r.join("")
		},
		parse: function(e) {
			for (var t = e.length, r = [], n = 0; n < t; n++)
				r[n >>> 2] |= (255 & e.charCodeAt(n)) << 24 - n % 4 * 8;
			return new s.init(r,t)
		}
	}
		, u = a.Utf8 = {
		stringify: function(e) {
			try {
				return decodeURIComponent(escape(f.stringify(e)))
			} catch (e) {
				throw Error("Malformed UTF-8 data")
			}
		},
		parse: function(e) {
			return f.parse(unescape(encodeURIComponent(e)))
		}
	}
		, d = n.BufferedBlockAlgorithm = o.extend({
		reset: function() {
			this._data = new s.init,
				this._nDataBytes = 0
		},
		_append: function(e) {
			"string" == typeof e && (e = u.parse(e)),
				this._data.concat(e),
				this._nDataBytes += e.sigBytes
		},
		_process: function(t) {
			var r = this._data
				, n = r.words
				, i = r.sigBytes
				, o = this.blockSize
				, a = i / (4 * o)
				, a = t ? e.ceil(a) : e.max((0 | a) - this._minBufferSize, 0);
			if (t = a * o,
					i = e.min(4 * t, i),
					t) {
				for (var c = 0; c < t; c += o)
					this._doProcessBlock(n, c);
				c = n.splice(0, t),
					r.sigBytes -= i
			}
			return new s.init(c,i)
		},
		clone: function() {
			var e = o.clone.call(this);
			return e._data = this._data.clone(),
				e
		},
		_minBufferSize: 0
	});
	n.Hasher = d.extend({
		cfg: o.extend(),
		init: function(e) {
			this.cfg = this.cfg.extend(e),
				this.reset()
		},
		reset: function() {
			d.reset.call(this),
				this._doReset()
		},
		update: function(e) {
			return this._append(e),
				this._process(),
				this
		},
		finalize: function(e) {
			return e && this._append(e),
				this._doFinalize()
		},
		blockSize: 16,
		_createHelper: function(e) {
			return function(t, r) {
				return new e.init(r).finalize(t)
			}
		},
		_createHmacHelper: function(e) {
			return function(t, r) {
				return new h.HMAC.init(e,r).finalize(t)
			}
		}
	});
	var h = r.algo = {};
	return r
}(Math);
!function() {
	var e = CryptoJS
		, t = e.lib
		, r = t.WordArray
		, n = t.Hasher
		, i = []
		, t = e.algo.SHA1 = n.extend({
		_doReset: function() {
			this._hash = new r.init([1732584193, 4023233417, 2562383102, 271733878, 3285377520])
		},
		_doProcessBlock: function(e, t) {
			for (var r = this._hash.words, n = r[0], o = r[1], s = r[2], a = r[3], c = r[4], f = 0; 80 > f; f++) {
				if (16 > f)
					i[f] = 0 | e[t + f];
				else {
					var u = i[f - 3] ^ i[f - 8] ^ i[f - 14] ^ i[f - 16];
					i[f] = u << 1 | u >>> 31
				}
				u = (n << 5 | n >>> 27) + c + i[f],
					u = 20 > f ? u + (1518500249 + (o & s | ~o & a)) : 40 > f ? u + (1859775393 + (o ^ s ^ a)) : 60 > f ? u + ((o & s | o & a | s & a) - 1894007588) : u + ((o ^ s ^ a) - 899497514),
					c = a,
					a = s,
					s = o << 30 | o >>> 2,
					o = n,
					n = u
			}
			r[0] = r[0] + n | 0,
				r[1] = r[1] + o | 0,
				r[2] = r[2] + s | 0,
				r[3] = r[3] + a | 0,
				r[4] = r[4] + c | 0
		},
		_doFinalize: function() {
			var e = this._data
				, t = e.words
				, r = 8 * this._nDataBytes
				, n = 8 * e.sigBytes;
			return t[n >>> 5] |= 128 << 24 - n % 32,
				t[14 + (n + 64 >>> 9 << 4)] = Math.floor(r / 4294967296),
				t[15 + (n + 64 >>> 9 << 4)] = r,
				e.sigBytes = 4 * t.length,
				this._process(),
				this._hash
		},
		clone: function() {
			var e = n.clone.call(this);
			return e._hash = this._hash.clone(),
				e
		}
	});
	e.SHA1 = n._createHelper(t),
		e.HmacSHA1 = n._createHmacHelper(t)
}();
var CryptoJS = CryptoJS || function(e, t) {
	var r = {}
		, n = r.lib = {}
		, i = n.Base = function() {
		function e() {}
		return {
			extend: function(t) {
				e.prototype = this;
				var r = new e;
				return t && r.mixIn(t),
					r.$super = this,
					r
			},
			create: function() {
				var e = this.extend();
				return e.init.apply(e, arguments),
					e
			},
			init: function() {},
			mixIn: function(e) {
				for (var t in e)
					e.hasOwnProperty(t) && (this[t] = e[t]);
				e.hasOwnProperty("toString") && (this.toString = e.toString)
			},
			clone: function() {
				return this.$super.extend(this)
			}
		}
	}()
		, o = n.WordArray = i.extend({
		init: function(e, t) {
			e = this.words = e || [],
				this.sigBytes = void 0 != t ? t : 4 * e.length
		},
		toString: function(e) {
			return (e || a).stringify(this)
		},
		concat: function(e) {
			var t = this.words
				, r = e.words
				, n = this.sigBytes
				, e = e.sigBytes;
			if (this.clamp(),
				n % 4)
				for (var i = 0; i < e; i++)
					t[n + i >>> 2] |= (r[i >>> 2] >>> 24 - i % 4 * 8 & 255) << 24 - (n + i) % 4 * 8;
			else if (65535 < r.length)
				for (i = 0; i < e; i += 4)
					t[n + i >>> 2] = r[i >>> 2];
			else
				t.push.apply(t, r);
			return this.sigBytes += e,
				this
		},
		clamp: function() {
			var t = this.words
				, r = this.sigBytes;
			t[r >>> 2] &= 4294967295 << 32 - r % 4 * 8,
				t.length = e.ceil(r / 4)
		},
		clone: function() {
			var e = i.clone.call(this);
			return e.words = this.words.slice(0),
				e
		},
		random: function(t) {
			for (var r = [], n = 0; n < t; n += 4)
				r.push(4294967296 * e.random() | 0);
			return o.create(r, t)
		}
	})
		, s = r.enc = {}
		, a = s.Hex = {
		stringify: function(e) {
			for (var t = e.words, e = e.sigBytes, r = [], n = 0; n < e; n++) {
				var i = t[n >>> 2] >>> 24 - n % 4 * 8 & 255;
				r.push((i >>> 4).toString(16)),
					r.push((15 & i).toString(16))
			}
			return r.join("")
		},
		parse: function(e) {
			for (var t = e.length, r = [], n = 0; n < t; n += 2)
				r[n >>> 3] |= parseInt(e.substr(n, 2), 16) << 24 - n % 8 * 4;
			return o.create(r, t / 2)
		}
	}
		, c = s.Latin1 = {
		stringify: function(e) {
			for (var t = e.words, e = e.sigBytes, r = [], n = 0; n < e; n++)
				r.push(String.fromCharCode(t[n >>> 2] >>> 24 - n % 4 * 8 & 255));
			return r.join("")
		},
		parse: function(e) {
			for (var t = e.length, r = [], n = 0; n < t; n++)
				r[n >>> 2] |= (255 & e.charCodeAt(n)) << 24 - n % 4 * 8;
			return o.create(r, t)
		}
	}
		, f = s.Utf8 = {
		stringify: function(e) {
			try {
				return decodeURIComponent(escape(c.stringify(e)))
			} catch (e) {
				throw Error("Malformed UTF-8 data")
			}
		},
		parse: function(e) {
			return c.parse(unescape(encodeURIComponent(e)))
		}
	}
		, u = n.BufferedBlockAlgorithm = i.extend({
		reset: function() {
			this._data = o.create(),
				this._nDataBytes = 0
		},
		_append: function(e) {
			"string" == typeof e && (e = f.parse(e)),
				this._data.concat(e),
				this._nDataBytes += e.sigBytes
		},
		_process: function(t) {
			var r = this._data
				, n = r.words
				, i = r.sigBytes
				, s = this.blockSize
				, a = i / (4 * s)
				, a = t ? e.ceil(a) : e.max((0 | a) - this._minBufferSize, 0)
				, t = a * s
				, i = e.min(4 * t, i);
			if (t) {
				for (var c = 0; c < t; c += s)
					this._doProcessBlock(n, c);
				c = n.splice(0, t),
					r.sigBytes -= i
			}
			return o.create(c, i)
		},
		clone: function() {
			var e = i.clone.call(this);
			return e._data = this._data.clone(),
				e
		},
		_minBufferSize: 0
	});
	n.Hasher = u.extend({
		init: function() {
			this.reset()
		},
		reset: function() {
			u.reset.call(this),
				this._doReset()
		},
		update: function(e) {
			return this._append(e),
				this._process(),
				this
		},
		finalize: function(e) {
			return e && this._append(e),
				this._doFinalize(),
				this._hash
		},
		clone: function() {
			var e = u.clone.call(this);
			return e._hash = this._hash.clone(),
				e
		},
		blockSize: 16,
		_createHelper: function(e) {
			return function(t, r) {
				return e.create(r).finalize(t)
			}
		},
		_createHmacHelper: function(e) {
			return function(t, r) {
				return d.HMAC.create(e, r).finalize(t)
			}
		}
	});
	var d = r.algo = {};
	return r
}(Math);
!function() {
	var e = CryptoJS
		, t = e.lib.WordArray;
	e.enc.Base64 = {
		stringify: function(e) {
			var t = e.words
				, r = e.sigBytes
				, n = this._map;
			e.clamp();
			for (var e = [], i = 0; i < r; i += 3)
				for (var o = (t[i >>> 2] >>> 24 - i % 4 * 8 & 255) << 16 | (t[i + 1 >>> 2] >>> 24 - (i + 1) % 4 * 8 & 255) << 8 | t[i + 2 >>> 2] >>> 24 - (i + 2) % 4 * 8 & 255, s = 0; 4 > s && i + .75 * s < r; s++)
					e.push(n.charAt(o >>> 6 * (3 - s) & 63));
			if (t = n.charAt(64))
				for (; e.length % 4; )
					e.push(t);
			return e.join("")
		},
		parse: function(e) {
			var e = e.replace(/\s/g, "")
				, r = e.length
				, n = this._map
				, i = n.charAt(64);
			i && -1 != (i = e.indexOf(i)) && (r = i);
			for (var i = [], o = 0, s = 0; s < r; s++)
				if (s % 4) {
					var a = n.indexOf(e.charAt(s - 1)) << s % 4 * 2
						, c = n.indexOf(e.charAt(s)) >>> 6 - s % 4 * 2;
					i[o >>> 2] |= (a | c) << 24 - o % 4 * 8,
						o++
				}
			return t.create(i, o)
		},
		_map: "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/="
	}
}(),
	function(e) {
		function t(e, t, r, n, i, o, s) {
			return ((e = e + (t & r | ~t & n) + i + s) << o | e >>> 32 - o) + t
		}
		function r(e, t, r, n, i, o, s) {
			return ((e = e + (t & n | r & ~n) + i + s) << o | e >>> 32 - o) + t
		}
		function n(e, t, r, n, i, o, s) {
			return ((e = e + (t ^ r ^ n) + i + s) << o | e >>> 32 - o) + t
		}
		function i(e, t, r, n, i, o, s) {
			return ((e = e + (r ^ (t | ~n)) + i + s) << o | e >>> 32 - o) + t
		}
		var o = CryptoJS
			, s = o.lib
			, a = s.WordArray
			, s = s.Hasher
			, c = o.algo
			, f = [];
		!function() {
			for (var t = 0; 64 > t; t++)
				f[t] = 4294967296 * e.abs(e.sin(t + 1)) | 0
		}(),
			c = c.MD5 = s.extend({
				_doReset: function() {
					this._hash = a.create([1732584193, 4023233417, 2562383102, 271733878])
				},
				_doProcessBlock: function(e, o) {
					for (var s = 0; 16 > s; s++) {
						var a = o + s
							, c = e[a];
						e[a] = 16711935 & (c << 8 | c >>> 24) | 4278255360 & (c << 24 | c >>> 8)
					}
					for (var a = this._hash.words, c = a[0], u = a[1], d = a[2], h = a[3], s = 0; 64 > s; s += 4)
						16 > s ? (c = t(c, u, d, h, e[o + s], 7, f[s]),
							h = t(h, c, u, d, e[o + s + 1], 12, f[s + 1]),
							d = t(d, h, c, u, e[o + s + 2], 17, f[s + 2]),
							u = t(u, d, h, c, e[o + s + 3], 22, f[s + 3])) : 32 > s ? (c = r(c, u, d, h, e[o + (s + 1) % 16], 5, f[s]),
							h = r(h, c, u, d, e[o + (s + 6) % 16], 9, f[s + 1]),
							d = r(d, h, c, u, e[o + (s + 11) % 16], 14, f[s + 2]),
							u = r(u, d, h, c, e[o + s % 16], 20, f[s + 3])) : 48 > s ? (c = n(c, u, d, h, e[o + (3 * s + 5) % 16], 4, f[s]),
							h = n(h, c, u, d, e[o + (3 * s + 8) % 16], 11, f[s + 1]),
							d = n(d, h, c, u, e[o + (3 * s + 11) % 16], 16, f[s + 2]),
							u = n(u, d, h, c, e[o + (3 * s + 14) % 16], 23, f[s + 3])) : (c = i(c, u, d, h, e[o + 3 * s % 16], 6, f[s]),
							h = i(h, c, u, d, e[o + (3 * s + 7) % 16], 10, f[s + 1]),
							d = i(d, h, c, u, e[o + (3 * s + 14) % 16], 15, f[s + 2]),
							u = i(u, d, h, c, e[o + (3 * s + 5) % 16], 21, f[s + 3]));
					a[0] = a[0] + c | 0,
						a[1] = a[1] + u | 0,
						a[2] = a[2] + d | 0,
						a[3] = a[3] + h | 0
				},
				_doFinalize: function() {
					var e = this._data
						, t = e.words
						, r = 8 * this._nDataBytes
						, n = 8 * e.sigBytes;
					for (t[n >>> 5] |= 128 << 24 - n % 32,
							 t[14 + (n + 64 >>> 9 << 4)] = 16711935 & (r << 8 | r >>> 24) | 4278255360 & (r << 24 | r >>> 8),
							 e.sigBytes = 4 * (t.length + 1),
							 this._process(),
							 e = this._hash.words,
							 t = 0; 4 > t; t++)
						r = e[t],
							e[t] = 16711935 & (r << 8 | r >>> 24) | 4278255360 & (r << 24 | r >>> 8)
				}
			}),
			o.MD5 = s._createHelper(c),
			o.HmacMD5 = s._createHmacHelper(c)
	}(Math),
	function() {
		var e = CryptoJS
			, t = e.lib
			, r = t.Base
			, n = t.WordArray
			, t = e.algo
			, i = t.EvpKDF = r.extend({
			cfg: r.extend({
				keySize: 4,
				hasher: t.MD5,
				iterations: 1
			}),
			init: function(e) {
				this.cfg = this.cfg.extend(e)
			},
			compute: function(e, t) {
				for (var r = this.cfg, i = r.hasher.create(), o = n.create(), s = o.words, a = r.keySize, r = r.iterations; s.length < a; ) {
					c && i.update(c);
					var c = i.update(e).finalize(t);
					i.reset();
					for (var f = 1; f < r; f++)
						c = i.finalize(c),
							i.reset();
					o.concat(c)
				}
				return o.sigBytes = 4 * a,
					o
			}
		});
		e.EvpKDF = function(e, t, r) {
			return i.create(r).compute(e, t)
		}
	}(),
CryptoJS.lib.Cipher || function(e) {
	var t = CryptoJS
		, r = t.lib
		, n = r.Base
		, i = r.WordArray
		, o = r.BufferedBlockAlgorithm
		, s = t.enc.Base64
		, a = t.algo.EvpKDF
		, c = r.Cipher = o.extend({
		cfg: n.extend(),
		createEncryptor: function(e, t) {
			return this.create(this._ENC_XFORM_MODE, e, t)
		},
		createDecryptor: function(e, t) {
			return this.create(this._DEC_XFORM_MODE, e, t)
		},
		init: function(e, t, r) {
			this.cfg = this.cfg.extend(r),
				this._xformMode = e,
				this._key = t,
				this.reset()
		},
		reset: function() {
			o.reset.call(this),
				this._doReset()
		},
		process: function(e) {
			return this._append(e),
				this._process()
		},
		finalize: function(e) {
			return e && this._append(e),
				this._doFinalize()
		},
		keySize: 4,
		ivSize: 4,
		_ENC_XFORM_MODE: 1,
		_DEC_XFORM_MODE: 2,
		_createHelper: function() {
			return function(e) {
				return {
					encrypt: function(t, r, n) {
						return ("string" == typeof r ? l : p).encrypt(e, t, r, n)
					},
					decrypt: function(t, r, n) {
						return ("string" == typeof r ? l : p).decrypt(e, t, r, n)
					}
				}
			}
		}()
	});
	r.StreamCipher = c.extend({
		_doFinalize: function() {
			return this._process(!0)
		},
		blockSize: 1
	});
	var f = t.mode = {}
		, u = r.BlockCipherMode = n.extend({
		createEncryptor: function(e, t) {
			return this.Encryptor.create(e, t)
		},
		createDecryptor: function(e, t) {
			return this.Decryptor.create(e, t)
		},
		init: function(e, t) {
			this._cipher = e,
				this._iv = t
		}
	})
		, f = f.CBC = function() {
		function t(t, r, n) {
			var i = this._iv;
			i ? this._iv = e : i = this._prevBlock;
			for (var o = 0; o < n; o++)
				t[r + o] ^= i[o]
		}
		var r = u.extend();
		return r.Encryptor = r.extend({
			processBlock: function(e, r) {
				var n = this._cipher
					, i = n.blockSize;
				t.call(this, e, r, i),
					n.encryptBlock(e, r),
					this._prevBlock = e.slice(r, r + i)
			}
		}),
			r.Decryptor = r.extend({
				processBlock: function(e, r) {
					var n = this._cipher
						, i = n.blockSize
						, o = e.slice(r, r + i);
					n.decryptBlock(e, r),
						t.call(this, e, r, i),
						this._prevBlock = o
				}
			}),
			r
	}()
		, d = (t.pad = {}).Pkcs7 = {
		pad: function(e, t) {
			for (var r = 4 * t, r = r - e.sigBytes % r, n = r << 24 | r << 16 | r << 8 | r, o = [], s = 0; s < r; s += 4)
				o.push(n);
			r = i.create(o, r),
				e.concat(r)
		},
		unpad: function(e) {
			e.sigBytes -= 255 & e.words[e.sigBytes - 1 >>> 2]
		}
	};
	r.BlockCipher = c.extend({
		cfg: c.cfg.extend({
			mode: f,
			padding: d
		}),
		reset: function() {
			c.reset.call(this);
			var e = this.cfg
				, t = e.iv
				, e = e.mode;
			if (this._xformMode == this._ENC_XFORM_MODE)
				var r = e.createEncryptor;
			else
				r = e.createDecryptor,
					this._minBufferSize = 1;
			this._mode = r.call(e, this, t && t.words)
		},
		_doProcessBlock: function(e, t) {
			this._mode.processBlock(e, t)
		},
		_doFinalize: function() {
			var e = this.cfg.padding;
			if (this._xformMode == this._ENC_XFORM_MODE) {
				e.pad(this._data, this.blockSize);
				var t = this._process(!0)
			} else
				t = this._process(!0),
					e.unpad(t);
			return t
		},
		blockSize: 4
	});
	var h = r.CipherParams = n.extend({
		init: function(e) {
			this.mixIn(e)
		},
		toString: function(e) {
			return (e || this.formatter).stringify(this)
		}
	})
		, f = (t.format = {}).OpenSSL = {
		stringify: function(e) {
			var t = e.ciphertext
				, e = e.salt
				, t = (e ? i.create([1398893684, 1701076831]).concat(e).concat(t) : t).toString(s);
			return t = t.replace(/(.{64})/g, "$1\n")
		},
		parse: function(e) {
			var e = s.parse(e)
				, t = e.words;
			if (1398893684 == t[0] && 1701076831 == t[1]) {
				var r = i.create(t.slice(2, 4));
				t.splice(0, 4),
					e.sigBytes -= 16
			}
			return h.create({
				ciphertext: e,
				salt: r
			})
		}
	}
		, p = r.SerializableCipher = n.extend({
		cfg: n.extend({
			format: f
		}),
		encrypt: function(e, t, r, n) {
			var n = this.cfg.extend(n)
				, i = e.createEncryptor(r, n)
				, t = i.finalize(t)
				, i = i.cfg;
			return h.create({
				ciphertext: t,
				key: r,
				iv: i.iv,
				algorithm: e,
				mode: i.mode,
				padding: i.padding,
				blockSize: e.blockSize,
				formatter: n.format
			})
		},
		decrypt: function(e, t, r, n) {
			return n = this.cfg.extend(n),
				t = this._parse(t, n.format),
				e.createDecryptor(r, n).finalize(t.ciphertext)
		},
		_parse: function(e, t) {
			return "string" == typeof e ? t.parse(e) : e
		}
	})
		, t = (t.kdf = {}).OpenSSL = {
		compute: function(e, t, r, n) {
			return n || (n = i.random(8)),
				e = a.create({
					keySize: t + r
				}).compute(e, n),
				r = i.create(e.words.slice(t), 4 * r),
				e.sigBytes = 4 * t,
				h.create({
					key: e,
					iv: r,
					salt: n
				})
		}
	}
		, l = r.PasswordBasedCipher = p.extend({
		cfg: p.cfg.extend({
			kdf: t
		}),
		encrypt: function(e, t, r, n) {
			return n = this.cfg.extend(n),
				r = n.kdf.compute(r, e.keySize, e.ivSize),
				n.iv = r.iv,
				e = p.encrypt.call(this, e, t, r.key, n),
				e.mixIn(r),
				e
		},
		decrypt: function(e, t, r, n) {
			return n = this.cfg.extend(n),
				t = this._parse(t, n.format),
				r = n.kdf.compute(r, e.keySize, e.ivSize, t.salt),
				n.iv = r.iv,
				p.decrypt.call(this, e, t, r.key, n)
		}
	})
}(),
	function() {
		var e = CryptoJS
			, t = e.lib.BlockCipher
			, r = e.algo
			, n = []
			, i = []
			, o = []
			, s = []
			, a = []
			, c = []
			, f = []
			, u = []
			, d = []
			, h = [];
		!function() {
			for (var e = [], t = 0; 256 > t; t++)
				e[t] = 128 > t ? t << 1 : t << 1 ^ 283;
			for (var r = 0, p = 0, t = 0; 256 > t; t++) {
				var l = p ^ p << 1 ^ p << 2 ^ p << 3 ^ p << 4
					, l = l >>> 8 ^ 255 & l ^ 99;
				n[r] = l,
					i[l] = r;
				var g = e[r]
					, m = e[g]
					, y = e[m]
					, v = 257 * e[l] ^ 16843008 * l;
				o[r] = v << 24 | v >>> 8,
					s[r] = v << 16 | v >>> 16,
					a[r] = v << 8 | v >>> 24,
					c[r] = v,
					v = 16843009 * y ^ 65537 * m ^ 257 * g ^ 16843008 * r,
					f[l] = v << 24 | v >>> 8,
					u[l] = v << 16 | v >>> 16,
					d[l] = v << 8 | v >>> 24,
					h[l] = v,
					r ? (r = g ^ e[e[e[y ^ g]]],
						p ^= e[e[p]]) : r = p = 1
			}
		}();
		var p = [0, 1, 2, 4, 8, 16, 32, 64, 128, 27, 54]
			, r = r.AES = t.extend({
			_doReset: function() {
				for (var e = this._key, t = e.words, r = e.sigBytes / 4, e = 4 * ((this._nRounds = r + 6) + 1), i = this._keySchedule = [], o = 0; o < e; o++)
					if (o < r)
						i[o] = t[o];
					else {
						var s = i[o - 1];
						o % r ? 6 < r && 4 == o % r && (s = n[s >>> 24] << 24 | n[s >>> 16 & 255] << 16 | n[s >>> 8 & 255] << 8 | n[255 & s]) : (s = s << 8 | s >>> 24,
							s = n[s >>> 24] << 24 | n[s >>> 16 & 255] << 16 | n[s >>> 8 & 255] << 8 | n[255 & s],
							s ^= p[o / r | 0] << 24),
							i[o] = i[o - r] ^ s
					}
				for (t = this._invKeySchedule = [],
						 r = 0; r < e; r++)
					o = e - r,
						s = r % 4 ? i[o] : i[o - 4],
						t[r] = 4 > r || 4 >= o ? s : f[n[s >>> 24]] ^ u[n[s >>> 16 & 255]] ^ d[n[s >>> 8 & 255]] ^ h[n[255 & s]]
			},
			encryptBlock: function(e, t) {
				this._doCryptBlock(e, t, this._keySchedule, o, s, a, c, n)
			},
			decryptBlock: function(e, t) {
				var r = e[t + 1];
				e[t + 1] = e[t + 3],
					e[t + 3] = r,
					this._doCryptBlock(e, t, this._invKeySchedule, f, u, d, h, i),
					r = e[t + 1],
					e[t + 1] = e[t + 3],
					e[t + 3] = r
			},
			_doCryptBlock: function(e, t, r, n, i, o, s, a) {
				for (var c = this._nRounds, f = e[t] ^ r[0], u = e[t + 1] ^ r[1], d = e[t + 2] ^ r[2], h = e[t + 3] ^ r[3], p = 4, l = 1; l < c; l++)
					 var g = n[f >>> 24] ^ i[u >>> 16 & 255] ^ o[d >>> 8 & 255] ^ s[255 & h] ^ r[p++]
						 , m = n[u >>> 24] ^ i[d >>> 16 & 255] ^ o[h >>> 8 & 255] ^ s[255 & f] ^ r[p++]
						 , y = n[d >>> 24] ^ i[h >>> 16 & 255] ^ o[f >>> 8 & 255] ^ s[255 & u] ^ r[p++]
						 , h = n[h >>> 24] ^ i[f >>> 16 & 255] ^ o[u >>> 8 & 255] ^ s[255 & d] ^ r[p++]
						 , f = g
						 , u = m
						 , d = y;
				g = (a[f >>> 24] << 24 | a[u >>> 16 & 255] << 16 | a[d >>> 8 & 255] << 8 | a[255 & h]) ^ r[p++],
					m = (a[u >>> 24] << 24 | a[d >>> 16 & 255] << 16 | a[h >>> 8 & 255] << 8 | a[255 & f]) ^ r[p++],
					y = (a[d >>> 24] << 24 | a[h >>> 16 & 255] << 16 | a[f >>> 8 & 255] << 8 | a[255 & u]) ^ r[p++],
					h = (a[h >>> 24] << 24 | a[f >>> 16 & 255] << 16 | a[u >>> 8 & 255] << 8 | a[255 & d]) ^ r[p++],
					e[t] = g,
					e[t + 1] = m,
					e[t + 2] = y,
					e[t + 3] = h
			},
			keySize: 8
		});
		e.AES = t._createHelper(r)
	}();
function getValues(sessionId, e, r) {
	// r.deviceType = r.deviceType || "pc";
	// var n = mjkf.getLocalStorage("sessionId") || n
	var n = sessionId || n
		, t = "1.0"
		// , r = JSON.stringify(r)
		, r = mjkf.aesEncrypt(r, mjkf.AKS, mjkf.AKS)
		, c = mjkf.getBJTime()
		, f = mjkf.AKS + "appKey" + mjkf.AK + "bizContent" + r + "formatjsonlocalecnmethod" + e + "sessionId" + n + "timestamp" + c + "v" + t + mjkf.AKS
		, u = CryptoJS.SHA1(f).toString().toUpperCase();
	return "bizContent:" + r + ",sign:" + u;
}