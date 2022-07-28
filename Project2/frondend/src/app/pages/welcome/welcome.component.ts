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
        text: "2022 - Monthly Payment"
      },
      xAxis: {
        type: 'category',
        data: ['Jan', 'Feb', 'Mar','Apr', 'May', 'June', 'July', 'Aug','Sep', 'Oct', 'Nov', 'Dec']
      },
      yAxis: {
        type: 'value'
      },
      series: [
        {
          data: [
            95,
            {
              value: 150,
              itemStyle: {
                color: '#a90000'
              }
            },
            110,
            80,
            70,
            110,
            130,
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
