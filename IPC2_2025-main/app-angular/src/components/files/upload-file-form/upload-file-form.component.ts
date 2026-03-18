import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { InfoFileResponse } from '../../../models/files/info-file-response';
import { UploadFileDataRequest } from '../../../models/files/upload-file-data-request';
import { FilesService } from '../../../services/files/files.service';
import { DownloadFileComponent } from "../download-file/download-file.component";

@Component({
  selector: 'app-upload-file-form',
  imports: [FormsModule, ReactiveFormsModule, DownloadFileComponent],
  templateUrl: './upload-file-form.component.html',
  styleUrl: './upload-file-form.component.css',
})
export class UploadFileFormComponent implements OnInit {
  uploadFileForm!: FormGroup;
  created: boolean = false;
  infoFileResponse!: InfoFileResponse;
  selectedFile: File | null = null;


  constructor(private formBuilder: FormBuilder, private filesService: FilesService) {

  }

  ngOnInit(): void {
    this.uploadFileForm = this.formBuilder.group(
      {
        fileObject: [null, [Validators.required]],
        name: ['', [Validators.required]]
      }
    );
  }

  submit(): void {
    console.log("se hizo submit");
    if (this.uploadFileForm.valid && this.selectedFile) {
      const fileData: UploadFileDataRequest = {
        fileObject: this.selectedFile,
        name: this.uploadFileForm.get('name')?.value
      };
      this.filesService.uploadFile(fileData).subscribe({
        next: (infoFileResponse: InfoFileResponse) => {
          this.created = true;
          this.infoFileResponse = infoFileResponse;
          console.log("subido");
          console.log(this.infoFileResponse);
        },
        error: (error) => {
          console.error("Error al subir archivo:", error);
        }
      });

    }
  }

  reset(): void {
    this.uploadFileForm.reset({
      fileObject: null,
      name: ''
    });
    this.selectedFile = null;
    this.created = false;
  }

  onFileChange(event: any): void {
    const files = event.target.files;

    if (files && files.length > 0) {
      this.selectedFile = files[0];

      this.uploadFileForm.get('fileObject')?.setValue(this.selectedFile?.name);

      this.uploadFileForm.get('fileObject')?.markAsTouched();
    } else {
      this.selectedFile = null;
      this.uploadFileForm.get('fileObject')?.setValue(null);
    }
  }
}
