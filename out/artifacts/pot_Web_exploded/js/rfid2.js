var app = angular.module('myApp', []);
var httpindex = 0;
app.controller('customersCtrl', function ($scope, $http) {
    test();
//	AngularJS_Init();
//	try{
//		mac=getMac();
//	}catch(e)
//	{
//		alert("开启ActiveX控件失败，请将站点加入受信任站点，并启用ActiveX控件支持！");
//	}

    $scope.item = {"jdzh": "", "uid": "", "state": "识别中.."};
    $scope.rfid = function () {
        $http({"url": "getRFID.shtml?mac=" + mac + "&httpindex=" + httpindex, timeout: 5 * 60 * 1000})
            .then(function successCallback(response) {
                var data = response.data;
                if (data.id == -1) {
                    $scope.item.state = ("识别失败，5分钟内未收到设备信息");
                    if (window.confirm("是否继续等待")) {
                        setTimeout(function () {
                            $scope.rfid();
                        }, 1000)
                    }

                }
                else {
                    $scope.item = {"jdzh": "NO." + data.jdzh, "uid": "ID." + data.uid};
                    $scope.item.state = "识别成功"
                }
            }, function errorCallback(response) {
                $scope.item.state = ("识别失败");
                setTimeout(function () {
                    $scope.rfid();
                }, 1000)
            });

        httpindex++;

    };
    $scope.rfid();

});

function getMac() {
    var locator = new ActiveXObject("WbemScripting.SWbemLocator");
    var service = locator.ConnectServer(".");

    var properties = service.ExecQuery("SELECT * FROM Win32_NetworkAdapterConfiguration ");
    var e = new Enumerator(properties);

    var i = 1;
    var mac = "";
    for (; !e.atEnd(); e.moveNext()) {
        var p = e.item();
        if (p.MACAddress == null)
            continue;
        mac += p.MACAddress.replace(/:/g, "") + ",";
        i++;


    }
    return mac;
}

var mac = -1;

function AngularJS_Init() {
    if (!!window.ActiveXObject || "ActiveXObject" in window) {
    }
    else {
        alert("请使用IE浏览器");
        //return ;
    }
    // mac=getMac();


}

function test() {

    alert(s);
}

function read() {
    var s = jsObj.readCard();
    alert(s);
}

function wirte() {
    var s = jsObj.wirte("http://", "101.132.120.186/cd.shtml?d=jdfkajkdjakjdk");
    alert(s);
}
	
