import { Component, OnInit } from '@angular/core';
import { HealthcareProvider } from 'src/app/model/HealthcareProvider';
import { HealthcareProviderService } from 'src/app/services/healthcare-provider-service.service';

@Component({
  selector: 'app-get-all-providers',
  templateUrl: './get-all-providers.component.html',
  styleUrls: ['./get-all-providers.component.css']
})
export class GetAllProvidersComponent implements OnInit {

  providers: HealthcareProvider[] = [];

  constructor(private healthcareProviderService: HealthcareProviderService) { }

  ngOnInit(): void {
    this.getAllProviders();
  }

  getAllProviders(): void {
    this.healthcareProviderService.getAllProviders().subscribe(
      data => this.providers = data,
      error => console.error('Error fetching providers:', error)
    );
  }

  deleteProvider(providerId: number): void {
    this.healthcareProviderService.deleteProviderById(providerId).subscribe(
      () => {
        console.log('Provider deleted');
        this.providers = this.providers.filter(provider => provider.providerId !== providerId);
      },
      error => console.error('Error deleting provider:', error)
    );
  }
}
