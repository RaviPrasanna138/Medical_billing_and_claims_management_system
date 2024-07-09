import { Component } from '@angular/core';
import { HealthcareProvider } from 'src/app/model/HealthcareProvider';
import { HealthcareProviderService } from 'src/app/services/healthcare-provider-service.service';

@Component({
  selector: 'app-add-provider',
  templateUrl: './add-provider.component.html',
  styleUrls: ['./add-provider.component.css']
})
export class AddProviderComponent {

  provider: HealthcareProvider = {
    providerName: '',
    providerPassword: '',
    providerEmail: '',
    providerSpeciality: '',
    providerId: 0
  };

  constructor(private healthcareProviderService: HealthcareProviderService) { }

  addProvider(): void {
    this.healthcareProviderService.addProvider(this.provider).subscribe(
      response => {
        console.log('Provider added:', response);
        // Clear the form or redirect as needed
      },
      error => console.error('Error adding provider:', error)
    );
  }
}
