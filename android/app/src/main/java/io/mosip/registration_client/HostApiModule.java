package io.mosip.registration_client;


import android.app.Application;
import android.content.Context;


import androidx.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.mosip.registration.clientmanager.repository.RegistrationCenterRepository;
import io.mosip.registration.clientmanager.service.LoginService;

import io.mosip.registration.clientmanager.spi.AuditManagerService;
import io.mosip.registration.clientmanager.spi.SyncRestService;
import io.mosip.registration.clientmanager.util.SyncRestUtil;
import io.mosip.registration.keymanager.spi.ClientCryptoManagerService;
import io.mosip.registration_client.api_services.AuthenticationApi;

import io.mosip.registration_client.api_services.MachineDetailsApi;
import io.mosip.registration_client.api_services.UserDetailsApi;

@Module
public class HostApiModule {


    Application application;
    Context appContext;

    public HostApiModule(Application application) {
        this.application = application;
        this.appContext = application.getApplicationContext();
    }

    @Provides
    Application providesApplication() {
        return application;
    }

    @Provides
    @NonNull
    public Context provideApplicationContext() {
        return appContext;
    }

    @Provides
    @Singleton
    UserDetailsApi getLoginActivityApi(LoginService loginService,
                                       RegistrationCenterRepository registrationCenterRepository) {
        return new UserDetailsApi(loginService, registrationCenterRepository);
    }

    @Provides
    @Singleton
    MachineDetailsApi getMachineDetailsApi(ClientCryptoManagerService clientCryptoManagerService) {
        return new MachineDetailsApi(clientCryptoManagerService);
    }


    @Provides
    @Singleton
    AuthenticationApi getAuthenticationApi(SyncRestService syncRestService,
                                           SyncRestUtil syncRestFactory,
                                           LoginService loginService,
                                           AuditManagerService auditManagerService) {
        return new AuthenticationApi(appContext, syncRestService, syncRestFactory,
                        loginService, auditManagerService);
    }

}
