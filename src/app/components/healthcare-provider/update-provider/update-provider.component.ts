import { Component } from '@angular/core';
import { HealthcareProvider } from 'src/app/model/HealthcareProvider';
import { HealthcareProviderService } from 'src/app/services/healthcare-provider-service.service';

@Component({
  selector: 'app-update-provider',
  templateUrl: './update-provider.component.html',
  styleUrls: ['./update-provider.component.css']
})
export class UpdateProviderComponent {

  provider: HealthcareProvider = {
    providerId: 0,
    providerName: '',
    providerPassword: '',
    providerEmail: '',
    providerSpeciality: ''
  };

  constructor(private healthcareProviderService: HealthcareProviderService) { }

  updateProvider(): void {
    if (this.provider.providerId) {
      this.healthcareProviderService.updateProvider(this.provider).subscribe(
        response => {
          console.log('Provider updated:', response);
          // Clear the form or redirect as needed
        },
        error => console.error('Error updating provider:', error)
      );
    }
  }
}
