import { Component } from '@angular/core';
import { UploadFileFormComponent } from "../../components/files/upload-file-form/upload-file-form.component";

@Component({
  selector: 'app-files-page',
  imports: [UploadFileFormComponent],
  templateUrl: './files-page.component.html',
  styleUrl: './files-page.component.css',
})
export class FilesPageComponent { }
