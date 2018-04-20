// JavaScript Document

//menu animation
$(function () {
    var winWidth = $(window).innerWidth()
    if (winWidth < 1000) {
        $.extend({
            'menuRetract': function () {
                $('.menu').addClass('retract');
                $('.menu').removeClass('open');
                setTimeout(function () {
                    $('.menu').addClass('dn');
                }, 300)
            },
            'menuOpen': function () {
                $('.menu').removeClass('dn');
                $('.menu').addClass('open');
                $('.menu').removeClass('retract');
            },
        })
        $('.menu-button-open').on('click', function () {
            console.log('11')
            if ($('.menu').is('.retract')) {
                $.menuOpen()
            }
        });
        $('.menu-button-close,.menu').on('click', function () {
            if ($('.menu').is('.open')) {
                $.menuRetract()
            }
        })
        $('.menu .list').on('click', function () {
            event.stopPropagation();
        })
    }
});


//header-nav
//$(function(){
//	var hdn = $('.header-nav')
//	var hdn_nav = hdn.find('.nav')
//	var hdn_nav_ul = hdn_nav.find('ul')
//	var hdn_nav_li = hdn_nav.find('li')
//	var hdn_menu = hdn.find('.menu')
//	var hdn_menu_ul = hdn_menu.find('ul')
//	var hdn_menu_li = hdn_menu.find('li')
//	
//	hdn_nav_li.on('mouseover',function(){
//		var thisNum1 = $(this).index()
//		hdn_menu_li.eq(thisNum1).addClass('activate')
//		hdn_menu_li.eq(thisNum1).slideDown(300)
//	})
//	hdn_nav_li.on('mouseout',function(){
//		var thisNum2 = $(this).index()
//		hdn_menu_li.eq(thisNum2).removeClass('activate')
//		hdn_menu_li.eq(thisNum2).slideup(300)
//	})
//	
//})

//win
$(function () {
    var body = $('body')
    var win = $('.win')
    var wm = win.find('.winMain')
    var wmi = wm.find('iframe')
    var openWin = $('.openWin')
    var closeWin = $('.closeWin')

    $.extend({
        'winClose': function () {
            win.removeClass('openAnimation')
            win.addClass('closeAnimation')
            body.css({
                overflowY: 'auto',
                height: 'auto'
            })
            wmi.fadeOut(1000)
            wm.fadeOut(1000)
            wmi.attr('src', ' ')
            setTimeout(function () {
                win.removeClass('closeAnimation')
                win.hide()
            }, 1000)
        },
        // 窗口外点击关闭
        'winOutclick': function () {
            win.click(function () {
                $.winClose()
            })
        },
        // 窗口外点击阻止
        'winInclick': function () {
            wm.click(function () {
                if (isFirefox = navigator.userAgent.indexOf("Firefox") > 0) {
                    var evt = window.event || arguments.callee.caller.arguments[0];
                    evt.stopPropagation();
                } else if (document.all) {
                    window.event.cancelBubble = true;
                } else {
                    event.stopPropagation();
                }
            })
        },
        // 关闭按钮点击事件
        'closeWin': function () {
            closeWin.click(function () {
                $.winClose()
            })
        },
        // 居中定位
        'winCenter': function () {
            var screenWidth = wm.innerWidth()
            var screenHeight = wm.innerHeight()
            wm.css({
                marginTop: screenHeight / 2 * (0 - 1),
                marginLeft: screenWidth / 2 * (0 - 1)
            })
        },
    })

    openWin.on('click', function () {
        var src = $(this).attr('name')
        wmi.attr('src', src)

        $(".iframeControl").load(function () {
            var winWidth = $(window).innerWidth()
            var winHeight = $(window).innerHeight()
            if (winWidth < 720) {

            } else if (winWidth >= 720) {
                var myiframeH = $(this).contents().find("body").height();
                $(this).height(myiframeH);
            }
            var screenWidth = wm.innerWidth()
            var screenHeight = wm.innerHeight()
            if (winWidth < 720) {

            } else if (winWidth >= 720) {
                if ((screenHeight + 100) <= winHeight) {
                    wm.css({
                        marginTop: screenHeight / 2 * (0 - 1),
                        marginLeft: screenWidth / 2 * (0 - 1),
                        marginBottom: '',
                        top: '',
                    })
                } else if ((screenHeight + 100) > winHeight) {
                    wm.css({
                        marginTop: '50px',
                        marginLeft: screenWidth / 2 * (0 - 1),
                        marginBottom: '50px',
                        top: '0',
                    })
                }
            }


        });

        body.css({
            overflowY: 'hidden',
            height: $(window).height() + 'px'
        })

//		document.addEventListener('touchmove', function (event) {
//		   event.preventDefault();
//		}, false);

        win.addClass('openAnimation')

        win.show()
        wm.fadeIn(1000, function () {
            $(this).css('display', 'block')
        })
        wmi.fadeIn(1000, function () {
            $(this).css('display', 'block')
        })
    })

    $.winOutclick()
    $.winInclick()
    $.closeWin()
})

//part
$(function () {
    var winHeight = $(window).innerHeight()
    $('.osTop,.osBottom,.osScale').each(function () {
        var oTop = $(this).offset().top
        var sTop = $(window).scrollTop()
        var os = oTop - sTop
        if (os <= (winHeight * 0.9)) {
            $(this).addClass('activate')
        }
    })
    $(window).scroll(function () {
        var winHeight0 = $(window).innerHeight()
        $('.osTop,.osBottom,.osScale').each(function () {
            var oTop = $(this).offset().top
            var sTop = $(window).scrollTop()
            var os = oTop - sTop
            if (os <= (winHeight0 * 0.9)) {
                $(this).addClass('activate')
            }
        })
    })
})
//shdzList target
$(function () {
    var shdzList = $('.shdzList')
    var targetAll = shdzList.find('.target')
    var targetBtn = shdzList.find('.target-btn')
    var deleteThis = shdzList.find('.delete')

    targetBtn.on('click', function () {
        targetAll.hide()
        $(this).parents('li').find('.target').show()
        targetBtn.show()
        $(this).hide()
    })

    deleteThis.on('click', function () {
        var id = this.id;
        var thisLi = $(this).parents('li')
        initShdzWinInfo(this);
        thisLi.addClass('active')
        $('.winMain.tips').find('.confirm').click(function () {
            $.ajax({
                "url": "user/userCenter_shdz_remove.shtml?id=" + id, success: function (msg) {
                    location.reload(true);

                }, error: function (a, b) {
                    alert(a + b);
                }
            })
            shdzList.find('.active').fadeOut(300, function () {
                shdzList.find('.active').remove()
            })
        })
        $('.winMain.tips').find('.cancel').click(function () {
            console.log(1)
            shdzList.find('.active').removeClass('active')
        })
    })
})
//drop-down
$(function () {
    var dropdown = $('.drop-down')

    dropdown.on('click', function () {
        var dropdown_btn = $(this).find('.btn')
        var dropdown_target = dropdown_btn.find('.target')
        var dropdown_list = $(this).find('.list')
        var dropdown_list_li = dropdown_list.find('li')
        $(this).next().find(".target").text("")
        if (dropdown_list.is(':visible')) {
            dropdown_list.slideUp()
        } else {
            dropdown_list.slideDown()
        }

        dropdown_list_li.on('click', function () {
            var thisText = $(this).text()
            dropdown_target.text(thisText)
        })

        $(window).click(function () {
            //dropdown_list.slideUp()
            dropdown.click(function () {
                if (isFirefox = navigator.userAgent.indexOf("Firefox") > 0) {
                    var evt = window.event || arguments.callee.caller.arguments[0];
                    evt.stopPropagation();
                } else if (document.all) {
                    window.event.cancelBubble = true;
                } else {
                    event.stopPropagation();
                }
            })
        })
    })


})