import com.bsb.data.ISpittleRepository;
import com.bsb.data.Spittle;
import com.bsb.web.controller.SpittleController;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;
import static org.hamcrest.Matchers.hasItems;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShouldShowRecentSpittles {

    @Test
    public void shouldShowRecentSpittles() throws Exception {
//        //准备测试数据
//        List<Spittle> expectedSpittles = createSpittleList(20);
//        ISpittleRepository mockRepository = mock(ISpittleRepository.class);
//        when(mockRepository.findSpittles(Long.MAX_VALUE, 20)).thenReturn(expectedSpittles);
////        SpittleController spittleController = new SpittleController(mockRepository);
//        MockMvc mockMvc = standaloneSetup(spittleController).setSingleView(
//                new InternalResourceView("/WEB-INF/views/spittles.jsp")).build();
//        mockMvc.perform(get("spittles")).andExpect(view().name("spittles")).
//                andExpect(model().attributeExists("spittleList")).andExpect(model().
//                attribute("spittleList", hasItems(expectedSpittles.toArray())));


    }

    private List<Spittle> createSpittleList(int count) {
        List<Spittle> spittles = new ArrayList<Spittle>();
        for (int i = 0; i < count; i++) {
            spittles.add(new Spittle("Spittle " + i, new Date()));
        }
        return spittles;
    }

    @Test
    public void shouldShowRegistration() throws Exception {
        SpittleController controller = new SpittleController();
        MockMvc mockMvc = standaloneSetup(controller).build();
        mockMvc.perform(get("/spitter/register")).andExpect(view().name("registerForm"));
    }
}
