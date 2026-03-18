import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Event } from '../../../../../models/events/event';

@Component({
  selector: 'app-confirmation-modal',
  imports: [],
  templateUrl: './confirmation-modal.component.html',
})
export class ConfirmationModalComponent {

  @Input()
  selectedEvent!: Event;

  @Output()
  confirmationExecuter = new EventEmitter<void>();

  executeConfirmation(): void {
    this.confirmationExecuter.emit();
  }
}
