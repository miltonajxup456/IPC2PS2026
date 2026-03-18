import { Component } from '@angular/core';

@Component({
  selector: 'app-counter-page',
  imports: [],
  templateUrl: './counter-page.component.html',
  styleUrl: './counter-page.component.css'
})
export class CounterPage {
  protected counter: number = 0;
  protected fontStyle: string;

  constructor() {
    this.fontStyle = '';
  }

  protected increase(): void {
    this.counter++;
  }

  protected reduce(): void {
    this.counter--;
  }

  protected reset(val: number): void {
    this.counter = val;
  }

  protected changeStyle(style: string): string {
    this.fontStyle = style;

    return this.fontStyle;
  }

}
