<%--
  Created by IntelliJ IDEA.
  User: 18727
  Date: 2023/5/12 0012
  Time: 14:20
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
            width: 900px;
            height: 600px;
        }
    </style>
</head>
<body>
<div id="main"></div>

<script type="text/javascript">
    $(function () {
        $.getJSON(
            "/echartsServlet",
            {tag: "film"},
            function (data) {
                var chartDom = document.getElementById('main');
                var myChart = echarts.init(chartDom);
                var option;
                var dataAxis = [];
                var datas = [];
                $.each(data, function (index, movie) {
                    var name = movie.filmName;
                    var views = movie.filmViews;

                    dataAxis.push(name);
                    datas.push(views);
                })
                let yMax = 3000000;
                let dataShadow = [];
                for (let i = 0; i < datas.length; i++) {
                    dataShadow.push(yMax);
                }
                option = {
                    title: {
                        text: '影视浏览量',
                        subtext: '统计各影视的浏览量'
                    },
                    xAxis: {
                        data: dataAxis,
                        axisLabel: {
                            inside: true,
                            color: '#fff'
                        },
                        axisTick: {
                            show: false
                        },
                        axisLine: {
                            show: false
                        },
                        z: 10
                    },
                    yAxis: {
                        axisLine: {
                            show: false
                        },
                        axisTick: {
                            show: false
                        },
                        axisLabel: {
                            color: '#999'
                        }
                    },
                    dataZoom: [
                        {
                            type: 'inside'
                        }
                    ],
                    series: [
                        {
                            type: 'bar',
                            showBackground: true,
                            itemStyle: {
                                color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [
                                    {offset: 0, color: '#83bff6'},
                                    {offset: 0.5, color: '#188df0'},
                                    {offset: 1, color: '#188df0'}
                                ])
                            },
                            emphasis: {
                                itemStyle: {
                                    color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [
                                        {offset: 0, color: '#2378f7'},
                                        {offset: 0.7, color: '#2378f7'},
                                        {offset: 1, color: '#83bff6'}
                                    ])
                                }
                            },
                            data: datas
                        }
                    ]
                };
                // Enable data zoom when user click bar.
                const zoomSize = 6;
                myChart.on('click', function (params) {
                    console.log(dataAxis[Math.max(params.dataIndex - zoomSize / 2, 0)]);
                    myChart.dispatchAction({
                        type: 'dataZoom',
                        startValue: dataAxis[Math.max(params.dataIndex - zoomSize / 2, 0)],
                        endValue:
                            dataAxis[Math.min(params.dataIndex + zoomSize / 2, data.length - 1)]
                    });
                });
                option && myChart.setOption(option);
            }
        )
    })
</script>
</body>
</html>
