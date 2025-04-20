package com.spring.ProgettoDemo.service;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ServiceImplProdotto {
	//gpt mi dice di aggiungere questo, 
	//per me è inutile oltre che credo che non sia corretto
	 
    @Autowired
    private RepositoryProdotto prodottoRepo;
    
    @Autowired
    private RepositoryNegozio negozioRepo;

    @Override
    public DtoProdotto createProdotto(DtoProdotto prodottoDto) {
        // Verifica che il negozio esista
        if (prodottoDto.getNegozioId() != null) {
            Negozio negozio = negozioRepo.findById(prodottoDto.getNegozioId())
                    .orElseThrow(() -> new ResourceNotFoundException("Negozio", "id", prodottoDto.getNegozioId()));
            
            Prodotto prodotto = Converti.convertiDtoProdotto(prodottoDto);
            prodotto.setNegozio(negozio);
            prodotto = prodottoRepo.save(prodotto);
            
            return Converti.convertiProdotto(prodotto);
        } else {
            throw new IllegalArgumentException("L'ID del negozio è obbligatorio");
        }
    }

    @Override
    public List<DtoProdotto> findAll() {
        List<Prodotto> prodotti = prodottoRepo.findAll();
        return prodotti.stream()
                .map(Converti::convertiProdotto)
                .collect(Collectors.toList());
    }

    @Override
    public DtoProdotto findById(Integer id) {
        Prodotto prodotto = prodottoRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Prodotto", "id", id));
        return Converti.convertiProdotto(prodotto);
    }

    @Override
    public List<DtoProdotto> findByNegozioId(Integer negozioId) {
        if (!negozioRepo.existsById(negozioId)) {
            throw new ResourceNotFoundException("Negozio", "id", negozioId);
        }
        
        List<Prodotto> prodotti = prodottoRepo.findByNegozioId(negozioId);
        return prodotti.stream()
                .map(Converti::convertiProdotto)
                .collect(Collectors.toList());
    }

    @Override
    public DtoProdotto updateProdotto(Integer id, DtoProdotto prodottoDto) {
        Prodotto prodotto = prodottoRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Prodotto", "id", id));
        
        // Se l'ID del negozio è cambiato, verifica che il nuovo negozio esista
        if (prodottoDto.getNegozioId() != null && 
            (prodotto.getNegozio() == null || !prodotto.getNegozio().getId().equals(prodottoDto.getNegozioId()))) {
            Negozio negozio = negozioRepo.findById(prodottoDto.getNegozioId())
                    .orElseThrow(() -> new ResourceNotFoundException("Negozio", "id", prodottoDto.getNegozioId()));
            prodotto.setNegozio(negozio);
        }
        
        prodotto.setNome(prodottoDto.getNome());
        prodotto = prodottoRepo.save(prodotto);
        
        return Converti.convertiProdotto(prodotto);
    }

    @Override
    public void deleteById(Integer id) {
        if (!prodottoRepo.existsById(id)) {
            throw new ResourceNotFoundException("Prodotto", "id", id);
        }
        prodottoRepo.deleteById(id);
    }

}
