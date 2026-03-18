import { Component } from "@angular/core";
import { EventFormComponent } from "../../../components/events/event-form-component/event-form.component";
import { RouterLink } from "@angular/router";

@Component({
  selector: 'app-create-event-page',
  imports: [EventFormComponent, RouterLink],
  templateUrl: './create-event-page.component.html',
})
export class CreateEventPageComponent {


}