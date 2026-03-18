import { Component, Input, input, OnInit } from "@angular/core";
import { Event } from "../../../models/events/event";
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators } from "@angular/forms";
import { EventTypeEnum } from "../../../models/events/event-type-enum";
import { KeyValuePipe, NgFor } from "@angular/common";
import { EventsService } from "../../../services/events/events.service";

@Component({
    selector: 'app-event-form',
    imports: [NgFor, FormsModule, ReactiveFormsModule, KeyValuePipe],
    templateUrl: './event-form.component.html',
})
export class EventFormComponent implements OnInit {

    @Input()
    isEditMode: boolean = false;
    @Input()
    eventToUpdate!: Event;

    newEventForm!: FormGroup;
    newEvent!: Event;
    eventTypeEnums = EventTypeEnum;
    operationDone: boolean = false;

    constructor(private formBuilder: FormBuilder,
        private eventsService: EventsService
    ) {

    }

    ngOnInit(): void {
        this.newEventForm = this.formBuilder.group(
            {
                code: [null, [Validators.required, Validators.maxLength(10)]],
                name: [null, [Validators.required, Validators.maxLength(100)]],
                limit: [null, Validators.required],
                eventType: [null, Validators.required],
                startDate: [new Date().toISOString().substring(0, 10), Validators.required],
                price: [null, [Validators.required, Validators.min(1)]],
            }
        );
        this.reset();
    }

    eventTypeOptions = Object.keys(EventTypeEnum).filter(val => isNaN(Number(val))).map(key => ({
        key: key,
        value: EventTypeEnum[key as keyof typeof EventTypeEnum]
    }));

    submit(): void {
        console.log('se hizo submit');
        if (this.newEventForm.valid) {
            if (this.isEditMode) {
                this.updateEvent();
            } else {
                this.saveNewEvent();
            }
        }
    }

    reset(): void {
        if (this.isEditMode) {
            this.resetOnEdit();
            console.log('reset edit');
        } else {
            this.resetOnCreate();
        }
        this.operationDone = false;
    }

    private resetOnCreate(): void {
        this.newEventForm.reset({
            eventType: EventTypeEnum.CHARLA,
            startDate: new Date().toISOString().substring(0, 10)
        });
    }

    private resetOnEdit(): void {
        this.newEventForm.reset(this.eventToUpdate);
    }

    private saveNewEvent(): void {
        this.newEvent = this.newEventForm.value as Event;
        this.eventsService.createNewEvent(this.newEvent).subscribe({
            next: () => {
                this.reset();
                this.operationDone = true;
            },
            error: (error: any) => {
                console.log(error);
            }
        });
        console.log(this.newEvent);
    }

    private updateEvent(): void {
        this.eventToUpdate = this.newEventForm.value as Event;
        const {code, ...eventToUpdateRequest} = this.eventToUpdate;
        this.eventsService.updateEvent(this.eventToUpdate.code, eventToUpdateRequest).subscribe({
            next: () => {
                this.reset();
                this.operationDone = true;
            },
            error: (error: any) => {
                console.log(error);
            }
        });
    }
}