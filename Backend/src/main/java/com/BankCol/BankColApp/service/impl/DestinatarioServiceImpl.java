package com.BankCol.BankColApp.service.impl;

import com.BankCol.BankColApp.domain.Destinatario;
import com.BankCol.BankColApp.dto.DestinatarioDTO;
import com.BankCol.BankColApp.mapper.DestinatarioMapper;
import com.BankCol.BankColApp.repository.DestinatarioRepository;
import com.BankCol.BankColApp.service.DestinatarioService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DestinatarioServiceImpl implements DestinatarioService {

    private final DestinatarioRepository destinatarioRepository;

    public DestinatarioServiceImpl(DestinatarioRepository destinatarioRepository) {
        this.destinatarioRepository = destinatarioRepository;
    }

    @Override
    public DestinatarioDTO guardarNuevoDestinatario(DestinatarioDTO destinatarioDTO) throws Exception {
        //Validar los datos del cliente
        if(destinatarioDTO == null) { throw new Exception("El destinatario es nulo"); }

        if(destinatarioDTO.getNumcuentaDestinatario() == null) { throw new Exception("El numero de cuenta es vacío"); }

        if(destinatarioDTO.getBancoDestinatario() == null || destinatarioDTO.getBancoDestinatario().isEmpty()) { throw new Exception("El banco está vacío"); }

        if(destinatarioDTO.getNombreDestinatario() == null || destinatarioDTO.getNombreDestinatario().isEmpty()) { throw new Exception("El nombre está vacío"); }

        if(destinatarioDTO.getApellidoDestinatario() == null || destinatarioDTO.getApellidoDestinatario().isEmpty()) { throw new Exception("El apellido está vacío"); }

        if (destinatarioDTO.getCuentaFavorita() == null) { throw new Exception("Diga si est cuenta favorita o no"); }

        //Validar que no exista un cliente con esa cedula
        Optional<Destinatario> destinatarioNumCuenta = destinatarioRepository.findDestinatarioByNumcuentaDestinatario(destinatarioDTO.getNumcuentaDestinatario());

        if(destinatarioNumCuenta.isPresent()) {
            throw new Exception("El cliente con cédula "+ destinatarioDTO.getNumcuentaDestinatario() +" ya se encuentra registrado");
        }


        //Registrar el destinatario en DB
        Destinatario destinatario = DestinatarioMapper.dtoToDomain(destinatarioDTO);
        destinatario = destinatarioRepository.save(destinatario);

        //Retornar el destinatario mapeado en DTO
        destinatarioDTO = DestinatarioMapper.domainToDto(destinatario);

        return destinatarioDTO;
    }

    @Override
    public List<DestinatarioDTO> buscarTodos() {
        return DestinatarioMapper.domainToDtoList(destinatarioRepository.findAll());
    }

    @Override
    public DestinatarioDTO buscarPorId(Integer id) throws Exception {
        if(id == null) { throw new Exception("Id nulo"); }
        return DestinatarioMapper.domainToDto(destinatarioRepository.getReferenceById(id));
    }

    @Override
    public DestinatarioDTO buscarPorCedula(Integer cedula) throws Exception {
        if(cedula == null) { throw new Exception("Cedula nula"); }
        return DestinatarioMapper.domainToDto(destinatarioRepository.findByCedulaDestinatario(cedula));
    }
}
