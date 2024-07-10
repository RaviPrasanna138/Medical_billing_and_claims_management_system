import { InsuranceCompany } from "./InsuranceCompany";

export interface InsurancePlans {
    planId: number;
    planName: string;
    planType: string;
    planCoverAmount: number;    planDetails: string;
    company:InsuranceCompany;

}