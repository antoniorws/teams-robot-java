package robo;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class RoboJavaToTeams {
    public static void main(String[] args) {
        String teamsWebhookURL = "SUA_URL_WEBHOOK_DO_TEAMS";
        String channelId = "NOME_DO_CANAL";
        
        
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpPost httpPost = new HttpPost(teamsWebhookURL);
            httpPost.addHeader("Content-Type", "application/json");

            String message = String.format("{\"channelId\":\"%s\", \"text\":\"Mensagem para o canal\"}", channelId);
            HttpEntity entity = new StringEntity(message);
            httpPost.setEntity(entity);

            CloseableHttpResponse response = httpClient.execute(httpPost);
            // Lógica para lidar com a resposta, se necessário.
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
