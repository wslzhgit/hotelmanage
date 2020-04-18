layui.use(['jquery','layer','table','form','laydate'], function() {
    var $ = layui.jquery,   //jquery
        layer = layui.layer,  //弹出层
        table = layui.table,  //数据表格
        form = layui.form,  //表单
        laydate = layui.laydate;   //日期

    //日期时间范围
    laydate.render({
        elem: '#test3'
        ,type: 'datetime'
        ,format:'yyyy/MM/dd HH:mm:ss'
        ,range: true
    });
    //定义会员查询的条件
    var queryJsonVip = {};

    var phoneIf = true;
    //初始化
    loadVip();

    //会员信息的方法级渲染
    function  loadVip() {
        table.render({
            elem: '#demo' //数据存放的容器，为table标签，其id="demo"
            , height: 412  //容器高度
            , url: 'vip/loadPageByPramas' //数据接口或者访问服务器端的数据路径
            , limit: 5   //自定义每一页的数据条数
            , where: queryJsonVip//设定异步数据接口的额外参数
            , limits: [2, 3, 5, 8, 10]
            , even: true  //逐行背景色深浅不一
            , page: true //开启分页
            , cols: [[ //表头  field: 'id'表示从实体对象的属性中取到数据放入容器里
                {type: 'checkbox'}
                , {field: 'id', title: 'ID', align: 'center', width: 80, sort: true}
                , {field: 'vipNum', title: '会员卡号', align: 'center', width: 220}
                //edit: 'text'为可以直接单击编辑此列中的单元格
                , {field: 'customerName', title: '客人姓名', width: 110, align: 'center', sort: true,edit: 'text'}
                , {field: 'vipRate', title: '会员类型', width: 120, align: 'center', sort: true,templet: '#viprate'}
                , {field: 'gender', title: '性别', width: 120, align: 'center', sort: true,templet: '#gender'}
                , {field: 'idcard', title: '身份证号', width: 220, align: 'center', sort: true}
                , {field: 'phone', title: '手机号', width: 180, align: 'center'}
                , {field: 'createDate', title: '创建时间', width:220, align: 'center'}
                , {fixed: 'right', title: '操作', width: 180, align: 'center', toolbar: '#barDemo'}
            ]],
            done: function (res, curr, count) {

            }
        });
    }

    //监听订单查询的form表单
    form.on('submit(demo1)', function(data){
        queryJsonVip = {};//每一次拼接清空以前的记录
        queryJsonVip['vipNum'] = data.field.vipNum;
        queryJsonVip['idcard'] = data.field.idcard;
        queryJsonVip['vipRate'] = data.field.vipRate;

        //执行条件查询
        loadVip();
        return false;  //阻止表单进行action提交
    });

    //监听工具条
    table.on('tool(test)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
        var data = obj.data; //获得当前行数据
        var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
        var tr = obj.tr; //获得当前行 tr 的 DOM 对象（如果有的话）

        if(layEvent === 'query'){ //查看

        } else if(layEvent === 'upd'){ //修改
            //回显手机号和会员类型
            $("#vip_id").val(data.id);
            $("#phone").val(data.phone);
            var vipRateStr = '';
            if(data.vipRate==0.9){
                vipRateStr = '<option value="0.9" selected>普通会员</option><option value="0.8">超级会员</option>';
            }else {
                vipRateStr = '<option value="0.8" selected>超级会员</option><option value="0.9">普通会员</option>'
            }
            $("#vipRate").html(vipRateStr);
            form.render("select"); //渲染下拉框
            //弹出界面
            layer.open({
                type:1,
                title:"修改会员信息界面",
                area:['400px','260px'],
                anim: 4,
                shade:0.5,
                content:$("#updVipDiv")
            });
            //监听订单查询的form表单
            form.on('submit(demo3)', function(data){
                if(phoneIf){
                    //执行修改
                    updVip(data.field,obj);
                    layer.closeAll();  //关闭弹框
                }else {
                    layer.msg('手机号有误！！', {icon: 2,time:2000,anim: 6,shade:0.5});
                }
                return false;  //阻止表单进行action提交
            });
        }
    });
    //手机号的唯一性验证
    $("#phone").change(function () {
        //验证手机号的唯一性
        checkPhone($(this).val());
    });
    //修改会员的姓名
    table.on('edit(test)', function(obj){ //注：edit是固定事件名，test是table原始容器的属性 lay-filter="对应的值"
        var updJsonVip = {};
        updJsonVip['id'] = obj.data.id; //被修改的数据id
        updJsonVip[obj.field] = obj.value;//修改后的数据
        //执行修改
        updVip(updJsonVip,"customerName");
    });

    //验证手机号的唯一性
    function checkPhone(phone) {
        $.ajax({
            type:"POST",  //请求方式，POST请求
            url:"vip/getCountByPramas",   //访问服务器端的路径
            async:false,  //允许ajax外部的变量获得去数据
            data:{"phone":phone},  //传到服务器端参数JSON格式数据
            success:function (data) {  //请求执行正常函数回调
                if(data>0){
                    phoneIf = false;
                    layer.tips('手机号已使用！！', $("#phone"), {tips: [2,'#fc1505'],time:2000,});
                }else {
                    phoneIf = true;
                    layer.tips('手机号可用。。', $("#phone"), {tips: [2,'green'],time:2000,});
                }
            },
            error:function () {  //请求执行异常时的函数回调
                layer.msg('服务器异常', {icon: 3,time:2000,anim: 6,shade:0.5});
            }
        });
    }
    //修改会员信息
    function updVip(updJsonVip,obj) {
        $.ajax({
            type:"POST",  //请求方式，POST请求
            url:"vip/xgByPrimaryKeySelective",   //访问服务器端的路径
            data:updJsonVip,  //传到服务器端参数JSON格式数据
            success:function (data) {  //请求执行正常函数回调
                if(data=="success"){
                    layer.msg('会员数据修改成功。。', {icon: 1,time:2000,anim: 4,shade:0.5});
                    if(obj!='customerName'){  //不修改会员姓名

                        obj.update({
                            vipRate: updJsonVip.vipRate
                            ,phone: updJsonVip.phone
                        });
                    }

                }else {
                    layer.msg('会员数据修改失败！！', {icon: 2,time:2000,anim: 5,shade:0.5});
                }
            },
            error:function () {  //请求执行异常时的函数回调
                layer.msg('服务器异常', {icon: 3,time:2000,anim: 6,shade:0.5});
            }
        });
    }


});