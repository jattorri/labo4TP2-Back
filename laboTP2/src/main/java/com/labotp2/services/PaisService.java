package com.labotp2.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.labotp2.entities.Pais;
import com.labotp2.repositories.PaisRepository;

@Service
public class PaisService implements BaseService<Pais>{
	
	private PaisRepository paisRepository;
	
	public PaisService(PaisRepository paisRepository) {
		this.paisRepository = paisRepository;
	}

	@Override
	@Transactional 
	public List<Pais> findAll() throws Exception {
		try {
			List<Pais> pais = paisRepository.findAll();
			return pais;
		}catch( Exception e){
			throw new Exception(e.getMessage());
		}
	}

	@Override
	@Transactional 
	public Pais findById(Long id) throws Exception {
		try {
			Optional<Pais> paisOptional = paisRepository.findById(id);
			return paisOptional.get();
		}catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}

	@Override
	@Transactional 
	public Pais save(Pais pais) throws Exception {
		try {
			pais = paisRepository.save(pais);
			return pais;
		}catch(Exception e){
			throw new Exception(e.getMessage());
		}
		
	}

	@Override
	@Transactional 
	public Pais update(Long id, Pais entity) throws Exception {
		try {Optional<Pais> paisOptional = paisRepository.findById(id);
		Pais pais = paisOptional.get();
		pais = paisRepository.save(pais);
		return pais;
		}catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
 
	@Override
	@Transactional 
	public boolean delete(Long id) throws Exception {
		try {
			if(paisRepository.existsById(id)) {
				paisRepository.deleteById(id);
				return true;
			} else {
				throw new Exception();
			}
		}catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

}
