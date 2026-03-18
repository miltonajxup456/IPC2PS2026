import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { RestConstants } from '../../shared/restapi/rest-constants';
import { Event } from '../../models/events/event';
import { Observable } from 'rxjs';
import { EventToUpdateRequest } from '../../models/events/update-event-request';

@Injectable({
  providedIn: 'root'
})
export class EventsService {

  restConstants = new RestConstants();

  constructor(private httpClient: HttpClient) { }

  public createNewEvent(event: Event): Observable<void> {
    return this.httpClient.post<void>(`${this.restConstants.getApiURL()}events`, event);
  }

  public getAllEvents(): Observable<Event[]> {
    return this.httpClient.get<Event[]>(`${this.restConstants.getApiURL()}events`);
  }

  public getEventByCode(code: string): Observable<Event> {
    return this.httpClient.get<Event>(`${this.restConstants.getApiURL()}events/${code}`);
  }

  public updateEvent(code: string, eventToUpdate: EventToUpdateRequest): Observable<Event> {
    return this.httpClient.put<Event>(`${this.restConstants.getApiURL()}events/${code}`, eventToUpdate);
  }

  public deleteEvent(code: string): Observable<void> {
    return this.httpClient.delete<void>(`${this.restConstants.getApiURL()}events/${code}`);
  }

}
