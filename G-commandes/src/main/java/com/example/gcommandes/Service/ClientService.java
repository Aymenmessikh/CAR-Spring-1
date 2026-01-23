package com.example.gcommandes.Service;

import com.example.gcommandes.Dto.ClientRequestDto;
import com.example.gcommandes.Dto.ClientResponseDto;
import com.example.gcommandes.Entity.Client;
import com.example.gcommandes.Respository.ClientRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void createClient(ClientRequestDto clientRequestDto) {
        Client client = new Client(clientRequestDto.getEmail(),clientRequestDto.getMdp(),
                clientRequestDto.getNom(),clientRequestDto.getPrenom());
        clientRepository.save(client);
    }

    public ClientResponseDto login(String email, String mdp) {
        Client client = clientRepository.getClientByEmail(email);
        if (client == null || !client.getMdp().equals(mdp)) {
            throw new UnsupportedOperationException("Les mots de passe ne correspondent pas");
        }
        return new ClientResponseDto(client.getId(),client.getEmail(),client.getNom(),client.getPrenom());
    }
    public ClientResponseDto getById(Long id) {
        Client client = clientRepository.findById(id).orElseThrow();
        return new ClientResponseDto(client.getId(), client.getEmail(), client.getNom(), client.getPrenom());
    }


}
