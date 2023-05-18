<%--
  Created by IntelliJ IDEA.
  User: 18727
  Date: 2023/5/12 0012
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="../../js/echarts.js"></script>
    <script src="../../js/jquery.js"></script>
    <style>
        * {
            margin: 0;
            padding: 0;
        }

        #main {
            width: 600px;
            height: 400px;
            margin: 100px auto;
        }
    </style>
</head>
<body>
<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<div id="main"></div>
<script type="text/javascript">
    $(function () {
        $.getJSON(
            "/echartsServlet",
            {tag: "user"},
            function (data) {
                for (var i = 0; i < data.length; i++) {
                    var chartDom = document.getElementById('main');
                    var myChart = echarts.init(chartDom);
                    var option;

                    option = {
                        backgroundColor: '#107cea',
                        title: {
                            text: '用户人数数据',
                            left: 'center',
                            top: 20,
                            textStyle: {
                                color: '#ccc'
                            }
                        },
                        tooltip: {
                            trigger: 'item'
                        },
                        visualMap: {
                            show: false,
                            min: 80,
                            max: 600,
                            inRange: {
                                colorLightness: [0, 1]
                            }
                        },
                        series: [
                            {
                                name: '数据',
                                type: 'pie',
                                radius: '55%',
                                center: ['50%', '50%'],
                                data: [
                                    {value: parseInt(data[0]), name: '用户'},
                                    {value: parseInt(data[1]), name: '管理员'},
                                ].sort(function (a, b) {
                                    return a.value - b.value;
                                }),
                                roseType: 'radius',
                                label: {
                                    color: 'rgba(255, 255, 255, 0.3)'
                                },
                                labelLine: {
                                    lineStyle: {
                                        color: 'rgba(255, 255, 255, 0.3)'
                                    },
                                    smooth: 0.2,
                                    length: 10,
                                    length2: 20
                                },
                                itemStyle: {
                                    color: '#f19795',
                                    shadowBlur: 200,
                                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                                },
                                animationType: 'scale',
                                animationEasing: 'elasticOut',
                                animationDelay: function (idx) {
                                    return Math.random() * 200;
                                }
                            }
                        ]
                    };
                    option && myChart.setOption(option);
                }
            }
        )
    })
</script>
</body>
</html>
