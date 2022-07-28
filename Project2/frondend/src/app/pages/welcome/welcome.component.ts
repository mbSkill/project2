import { Component, OnInit } from '@angular/core';
import * as echarts from 'echarts';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.less'],

})
export class WelcomeComponent implements OnInit {


  constructor() { }

  ngOnInit(): void {
    type EChartsOption = echarts.EChartsOption;

    var chartDom = document.getElementById('main')!;
    var myChart = echarts.init(chartDom);
    var option: EChartsOption;

    option = {
      title:{
        text: "2022 - Monthly Payment",
        textStyle: {
          fontWeight:"bold",
          fontSize:"30"
        }
      },
      xAxis: {
        type: 'category',
        data: ['Jan', 'Feb', 'Mar','Apr', 'Ma·y', 'June', 'July', 'Aug','Sep', 'Oct', 'Nov', 'Dec']
      },
      yAxis: {
        type: 'value'
      },
      series: [
        {
          data: [
            110,
            110,
            {
              value: 150,
              itemStyle: {
                color: '#a90000'
              }
            },
            100,
            100,
            110,
            95,
            120,
            0,
            0,
            0,
            0
          ],
          type: 'bar'
        }
      ]
    };

    option && myChart.setOption(option);

    
  }

}
