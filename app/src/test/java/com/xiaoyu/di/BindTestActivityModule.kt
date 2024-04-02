package com.hsbc.mobilebanking.cashinstallmentjourney.di

import com.hsbc.mobilebanking.cashinstallmentjourney.base.BaseActivity
import com.hsbc.mobilebanking.cashinstallmentjourney.screen.CIPDashboardActivity
import com.hsbc.mobilebanking.cashinstallmentjourney.screen.banklist.CIPBankListFragment
import com.hsbc.mobilebanking.cashinstallmentjourney.screen.cardIssuerList.CIPCardIssuerListFragment
import com.hsbc.mobilebanking.cashinstallmentjourney.screen.confirmation.CIPConfirmationFragment
import com.hsbc.mobilebanking.cashinstallmentjourney.screen.dashboard.CIPDashboardFragment
import com.hsbc.mobilebanking.cashinstallmentjourney.screen.detail.CIPPlanDetailFragment
import com.hsbc.mobilebanking.cashinstallmentjourney.screen.error.CIPBackToAccountErrorFragment
import com.hsbc.mobilebanking.cashinstallmentjourney.screen.ineligible.CIPInEligibleFragment
import com.hsbc.mobilebanking.cashinstallmentjourney.screen.moreinfo.CIPMoreInfoActivity
import com.hsbc.mobilebanking.cashinstallmentjourney.screen.moreinfo.CIPMoreInfoFragment
import com.hsbc.mobilebanking.cashinstallmentjourney.screen.offer.CIPOfferLandingFragment
import com.hsbc.mobilebanking.cashinstallmentjourney.screen.onboarding.CIPOnBoardingActivity
import com.hsbc.mobilebanking.cashinstallmentjourney.screen.onboarding.CIPOnBoardingFragment
import com.hsbc.mobilebanking.cashinstallmentjourney.screen.onboarding.CIPOnBoardingSecondPageFragment
import com.hsbc.mobilebanking.cashinstallmentjourney.screen.paymentschedule.CIPPaymentScheduleActivity
import com.hsbc.mobilebanking.cashinstallmentjourney.screen.paymentschedule.CIPPaymentScheduleFragment
import com.hsbc.mobilebanking.cashinstallmentjourney.screen.receivingaccount.CIPReceivingAccountFragment
import com.hsbc.mobilebanking.cashinstallmentjourney.screen.review.CIPReviewFragment
import com.hsbc.mobilebanking.cashinstallmentjourney.screen.selectcreditcard.CIPSelectCreditCardFragment
import com.hsbc.mobilebanking.cashinstallmentjourney.screen.selecttenure.CIPSelectTenureFragment
import com.hsbc.mobilebanking.cashinstallmentjourney.screen.tandc.CIPTermsAndConditionsINFragment
import com.hsbc.mobilebanking.cashinstallmentjourney.screen.tandc.CIPTermsAndConditionTextFragment
import com.hsbc.mobilebanking.cashinstallmentjourney.screen.tandc.CIPTermsAndConditionsFragment
import com.hsbc.mobilebanking.cashinstallmentjourney.screen.tandc.CIPTermsAndConditionsParentFragment
import com.hsbc.mobilebanking.cashinstallmentjourney.screen.tandc.CIPWebLinkActivity
import com.hsbc.mobilebanking.cashinstallmentjourney.screen.tandc.CIPWebLinkFragment
import com.hsbc.mobilebanking.cashinstallmentjourney.view.testactivity.TestRoboActivity
import com.xiaoyu.di.RoboTestViewModelModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(
    includes = [
        RoboTestViewModelModule::class,
        CashInstallmentTenureModule::class
    ]
)
internal abstract class BindRoboTestActivityModule {
    @ContributesAndroidInjector
    abstract fun bindBaseActivity(): BaseActivity

    @ContributesAndroidInjector
    abstract fun bindTestRoboActivity(): TestRoboActivity

    /*** Journey UI injection consumer bindings ***/
    @ContributesAndroidInjector
    internal abstract fun contributeCIPHostActivity(): CIPDashboardActivity

    @ContributesAndroidInjector
    internal abstract fun contributeCIPHostFragment(): CIPDashboardFragment

    @ContributesAndroidInjector
    internal abstract fun contributeCIPOfferFragment(): CIPOfferLandingFragment

    @ContributesAndroidInjector
    internal abstract fun contributeCIPOnBoardingActivity(): CIPOnBoardingActivity

    @ContributesAndroidInjector
    internal abstract fun contributeCIPOnBoardingFragment(): CIPOnBoardingFragment

    @ContributesAndroidInjector
    internal abstract fun contributeCIPOnBoardingSecondPageFragment(): CIPOnBoardingSecondPageFragment

    @ContributesAndroidInjector
    internal abstract fun contributeCIPSelectTenureFragment(): CIPSelectTenureFragment

    @ContributesAndroidInjector
    internal abstract fun contributeCIPReceivingAccountFragment(): CIPReceivingAccountFragment

    @ContributesAndroidInjector
    internal abstract fun contributeCIPReviewFragment(): CIPReviewFragment

    @ContributesAndroidInjector
    internal abstract fun contributeCIPTermsAndConditionsFragment(): CIPTermsAndConditionsFragment

    @ContributesAndroidInjector
    internal abstract fun contributeCIPTermsAndConditionsTextFragment(): CIPTermsAndConditionTextFragment

    @ContributesAndroidInjector
    internal abstract fun contributeCIPTermsAndConditionsINFragment(): CIPTermsAndConditionsINFragment

    @ContributesAndroidInjector
    internal abstract fun contributeCIPTermsAndConditionsParentFragment(): CIPTermsAndConditionsParentFragment

    @ContributesAndroidInjector
    internal abstract fun contributeCIPTBankListFragment(): CIPBankListFragment

    @ContributesAndroidInjector
    internal abstract fun contributeCIPMoreInfoActivity(): CIPMoreInfoActivity

    @ContributesAndroidInjector
    internal abstract fun contributeCIPMoreInfoFragment(): CIPMoreInfoFragment

    @ContributesAndroidInjector
    internal abstract fun contributeCIPConfirmationFragment(): CIPConfirmationFragment

    @ContributesAndroidInjector
    internal abstract fun contributeCIPPaymentScheduleActivity(): CIPPaymentScheduleActivity

    @ContributesAndroidInjector
    internal abstract fun contributeCIPPAymentScheduleFragment(): CIPPaymentScheduleFragment

    @ContributesAndroidInjector
    internal abstract fun contributeCIPPlanDetailFragment(): CIPPlanDetailFragment

    @ContributesAndroidInjector
    internal abstract fun contributeCIPInEligibleFragment(): CIPInEligibleFragment

    @ContributesAndroidInjector
    internal abstract fun contributeCIPWebLinkActivity(): CIPWebLinkActivity

    @ContributesAndroidInjector
    internal abstract fun contributeCIPWebLinkFragment(): CIPWebLinkFragment

    @ContributesAndroidInjector
    internal abstract fun contributeCIPSelectCreditCardFragment(): CIPSelectCreditCardFragment

    @ContributesAndroidInjector
    internal abstract fun contributeCIPBackToAccountErrorFragment(): CIPBackToAccountErrorFragment

    @ContributesAndroidInjector
    internal abstract fun contributeCIPCardIssuerListFragment(): CIPCardIssuerListFragment
}