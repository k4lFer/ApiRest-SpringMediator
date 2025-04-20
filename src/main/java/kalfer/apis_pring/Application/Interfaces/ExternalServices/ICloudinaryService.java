package kalfer.apis_pring.Application.Interfaces.ExternalServices;

import java.util.UUID;

import kalfer.apis_pring.Application.Common.Result;

public interface ICloudinaryService {
    Result<Object> UploadFile(byte[] file, String fileName, UUID id);
    
    Result<Object> DeleteFile(String publicId);
}
