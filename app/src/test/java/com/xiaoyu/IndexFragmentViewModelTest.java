package com.xiaoyu;

import androidx.test.core.app.ApplicationProvider;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.mockk.MockKAnnotations;
import io.mockk.impl.annotations.MockK;

@RunWith(AndroidJUnit4::class)
public class IndexFragmentViewModelTest {
    @MockK
    lateinit var repository: com.mytest.xiaoyu.network.MyTestRepositoryRepository

    private lateinit var viewModel: CIPKeyFactStatementViewModel

    private val context = ApplicationProvider.getApplicationContext<Application>()

    @Before
    fun setup() {
        MockKAnnotations.init(this, relaxed = true)
        viewModel = CIPKeyFactStatementViewModel(repository)
    }

    @Test
    fun testSuccessResponse(){
        var inputStream: InputStream? = null
        coEvery { repository.downloadPdf(any()) }.answers {
            context.contentResolver.openInputStream(
                    getUriToResource(
                            InstrumentationRegistry.getInstrumentation().context.resources,
                            R.drawable.cip_non_activate
                    )
            )?.let {
                inputStream = it
                CashInstallmentResult.Success(it)
            }?: run { CashInstallmentResult.Error(HsbcException(HsbcException.ErrorType.ERROR)) }
        }
        Truth.assertThat(viewModel.inputStreamResponse.value).isEqualTo(inputStream)
    }

    @Test
    fun testErrorResponse(){
        var exception: CashInstallmentResult.Error? = null
        coEvery { repository.downloadPdf(any()) }.answers {
            exception = CashInstallmentResult.Error(HsbcException(HsbcException.ErrorType.ERROR))
            CashInstallmentResult.Error(HsbcException(HsbcException.ErrorType.ERROR))
        }
        Truth.assertThat(viewModel.exceptionLiveData.value).isEqualTo(exception)
    }

    private fun getUriToResource(
            res: Resources,
            @AnyRes resId: Int
    ): Uri {
        return Uri.parse(
                ContentResolver.SCHEME_ANDROID_RESOURCE +
                        "://" + res.getResourcePackageName(resId)
                        + '/' + res.getResourceTypeName(resId)
                        + '/' + res.getResourceEntryName(resId)
        )
    }
}
