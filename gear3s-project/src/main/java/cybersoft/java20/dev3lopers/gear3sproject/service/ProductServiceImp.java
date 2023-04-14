package cybersoft.java20.dev3lopers.gear3sproject.service;

import cybersoft.java20.dev3lopers.gear3sproject.dto.CategoryDTO;
import cybersoft.java20.dev3lopers.gear3sproject.dto.ProductDTO;
import cybersoft.java20.dev3lopers.gear3sproject.entity.Category;
import cybersoft.java20.dev3lopers.gear3sproject.entity.Product;
import cybersoft.java20.dev3lopers.gear3sproject.repository.ProductRepository;
import cybersoft.java20.dev3lopers.gear3sproject.service.imp.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service

public class ProductServiceImp implements ProductService {

    @Autowired
    ProductRepository productRepository;
    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> products =null;
        products=productRepository.findAll();
        List<ProductDTO> productDTOs = new ArrayList<>();
        if (products !=null)
        {
            for (Product product :products
                 ) {
                ProductDTO productDTO= new ProductDTO();
                productDTO.setId(product.getId());
                productDTO.setName(product.getName());
                productDTO.setPrice_origin(product.getOriginPrice());
                productDTO.setPrice_discount(product.getDiscountPrice());
                productDTO.setInventory(product.getInventory());
                productDTO.setSold_qty(product.getSoldQty());
                productDTO.setDescription(product.getDescription());
                productDTO.setCreate_date(product.getCreate_date());
                productDTO.setView_qty(product.getView_qty());
                productDTO.setDiscount_per(product.getDiscount_per());





                /*ManufacturerDTO manufacturerDTO = new ManufacturerDTO();
                Manufacturer manufacturer=product.getManufacturer();
                if (manufacturer==null)
                {
                    manufacturerDTO.setId(-1);
                    manufacturerDTO.setName("null");

                }else
                {
                    manufacturerDTO.setId(manufacturer.getId());
                    manufacturerDTO.setName(manufacturer.getName());
                }*/


                CategoryDTO categoryDTO = new CategoryDTO();
                Category category = product.getCategory();
                /*if (manufacturer==null)
                {
                    categoryDTO.setId(-1);
                    categoryDTO.setName("null");
                }else
                {
                    categoryDTO.setId(category.getId());
                    categoryDTO.setName(category.getName());
                }*/


                productDTO.setCategoryDTO(categoryDTO);
                //productDTO.setManufacturerDTO(manufacturerDTO);

                productDTOs.add(productDTO);
            }
            return productDTOs;
        }else
        {
            return null;
        }


    }

    @Override
    public ProductDTO findById(int id) {
        Product product= productRepository.findById(id);
        if (product!=null)
        {
            ProductDTO productDTO= new ProductDTO();
            productDTO.setId(product.getId());
            productDTO.setName(product.getName());
            productDTO.setPrice_origin(product.getOriginPrice());
            productDTO.setPrice_discount(product.getDiscountPrice());
            productDTO.setInventory(product.getInventory());
            productDTO.setSold_qty(product.getSoldQty());
            productDTO.setDescription(product.getDescription());
            productDTO.setCreate_date(product.getCreate_date());
            productDTO.setView_qty(product.getView_qty());

            productDTO.setDiscount_per(product.getDiscount_per());





            /*ManufacturerDTO manufacturerDTO = new ManufacturerDTO();
            Manufacturer manufacturer=product.getManufacturer();
            if (manufacturer==null)
            {
                manufacturerDTO.setId(-1);
                manufacturerDTO.setName("null");

            }else
            {
                manufacturerDTO.setId(manufacturer.getId());
                manufacturerDTO.setName(manufacturer.getName());
            }*/


            CategoryDTO categoryDTO = new CategoryDTO();
            Category category = product.getCategory();
            /*if (manufacturer==null)
            {
                categoryDTO.setId(-1);
                categoryDTO.setName("null");
            }else
            {
                categoryDTO.setId(category.getId());
                categoryDTO.setName(category.getName());
            }*/


            productDTO.setCategoryDTO(categoryDTO);
            //productDTO.setManufacturerDTO(manufacturerDTO);
            return productDTO;
        }else
        {
            return null;
        }
    }

    @Override
    public List<ProductDTO> findByPriceDiscount(int minPrice ,int maxPrice ) {
        List<Product> products = productRepository.findByDiscountPrice(minPrice,maxPrice);
        List<ProductDTO > productDTOS = new ArrayList<>();
        if (products!=null)
        {
            for (Product product : products
            ) {
                ProductDTO productDTO= new ProductDTO();
                productDTO.setId(product.getId());
                productDTO.setName(product.getName());
                productDTO.setPrice_origin(product.getOriginPrice());
                productDTO.setPrice_discount(product.getDiscountPrice());
                productDTO.setInventory(product.getInventory());
                productDTO.setSold_qty(product.getSoldQty());
                productDTO.setDescription(product.getDescription());
                productDTO.setCreate_date(product.getCreate_date());
                productDTO.setView_qty(product.getView_qty());

                productDTO.setDiscount_per(product.getDiscount_per());





                /*ManufacturerDTO manufacturerDTO = new ManufacturerDTO();
                Manufacturer manufacturer=product.getManufacturer();
                if (manufacturer==null)
                {
                    manufacturerDTO.setId(-1);
                    manufacturerDTO.setName("null");

                }else
                {
                    manufacturerDTO.setId(manufacturer.getId());
                    manufacturerDTO.setName(manufacturer.getName());
                }*/


                CategoryDTO categoryDTO = new CategoryDTO();
                Category category = product.getCategory();
                /*if (manufacturer==null)
                {
                    categoryDTO.setId(-1);
                    categoryDTO.setName("null");
                }else
                {
                    categoryDTO.setId(category.getId());
                    categoryDTO.setName(category.getName());
                }*/


                productDTO.setCategoryDTO(categoryDTO);
                //productDTO.setManufacturerDTO(manufacturerDTO);

                productDTOS.add(productDTO);
            }

            return productDTOS;
        }else
        {
            return null;
        }
    }

    @Override
    public List<ProductDTO> findByName(String name) {
        List<Product> products = productRepository.findByName(name );
        List<ProductDTO > productDTOS = new ArrayList<>();
        if (products!=null)
        {
            for (Product product : products
            ) {
                ProductDTO productDTO= new ProductDTO();
                productDTO.setId(product.getId());
                productDTO.setName(product.getName());
                productDTO.setPrice_origin(product.getOriginPrice());
                productDTO.setPrice_discount(product.getDiscountPrice());
                productDTO.setInventory(product.getInventory());
                productDTO.setSold_qty(product.getSoldQty());
                productDTO.setDescription(product.getDescription());
                productDTO.setCreate_date(product.getCreate_date());
                productDTO.setView_qty(product.getView_qty());

                productDTO.setDiscount_per(product.getDiscount_per());





                /*ManufacturerDTO manufacturerDTO = new ManufacturerDTO();
                Manufacturer manufacturer=product.getManufacturer();
                if (manufacturer==null)
                {
                    manufacturerDTO.setId(-1);
                    manufacturerDTO.setName("null");

                }else
                {
                    manufacturerDTO.setId(manufacturer.getId());
                    manufacturerDTO.setName(manufacturer.getName());
                }*/


                CategoryDTO categoryDTO = new CategoryDTO();
                Category category = product.getCategory();
                /*if (manufacturer==null)
                {
                    categoryDTO.setId(-1);
                    categoryDTO.setName("null");
                }else
                {
                    categoryDTO.setId(category.getId());
                    categoryDTO.setName(category.getName());
                }*/


                productDTO.setCategoryDTO(categoryDTO);
                //productDTO.setManufacturerDTO(manufacturerDTO);
                productDTOS.add(productDTO);
            }

            return productDTOS;
        }else
        {
            return null;
        }
    }

    @Override
    public  List<ProductDTO> findByPriceOrigin(int min,int max ) {
        List<Product> products = productRepository.findByOriginPrice(min ,max );
        List<ProductDTO > productDTOS = new ArrayList<>();
        if (products!=null)
        {
            for (Product product : products
                 ) {
                ProductDTO productDTO= new ProductDTO();
                productDTO.setId(product.getId());
                productDTO.setName(product.getName());
                productDTO.setPrice_origin(product.getOriginPrice());
                productDTO.setPrice_discount(product.getDiscountPrice());
                productDTO.setInventory(product.getInventory());
                productDTO.setSold_qty(product.getSoldQty());
                productDTO.setDescription(product.getDescription());
                productDTO.setCreate_date(product.getCreate_date());
                productDTO.setView_qty(product.getView_qty());
                productDTO.setDiscount_per(product.getDiscount_per());





                /*ManufacturerDTO manufacturerDTO = new ManufacturerDTO();
                Manufacturer manufacturer=product.getManufacturer();
                if (manufacturer==null)
                {
                    manufacturerDTO.setId(-1);
                    manufacturerDTO.setName("null");

                }else
                {
                    manufacturerDTO.setId(manufacturer.getId());
                    manufacturerDTO.setName(manufacturer.getName());
                }*/


                CategoryDTO categoryDTO = new CategoryDTO();
                Category category = product.getCategory();
                /*if (manufacturer==null)
                {
                    categoryDTO.setId(-1);
                    categoryDTO.setName("null");
                }else
                {
                    categoryDTO.setId(category.getId());
                    categoryDTO.setName(category.getName());
                }*/


                productDTO.setCategoryDTO(categoryDTO);
                //productDTO.setManufacturerDTO(manufacturerDTO);
                productDTOS.add(productDTO);
            }

            return productDTOS;
        }else
        {
            return null;
        }
    }

    @Override
    public boolean deleteProductById(int id) {
        Product product= null;
        product = productRepository.findById(id);
        if (product!=null)
        {
            productRepository.deleteById(id);
            return true ;
        }else
        {
            return false ;
        }
    }

    @Override
    public boolean updateProductById(int id,ProductDTO productDTO) {
        Product product=null;
        product=productRepository.findById(id);
        if (product!=null)
        {
            product.setName(productDTO.getName());
            product.setOriginPrice(productDTO.getPrice_origin());
            product.setDiscountPrice(productDTO.getPrice_discount());
            product.setInventory(productDTO.getInventory());
            product.setSoldQty(productDTO.getSold_qty());
            product.setDescription(productDTO.getDescription());

//            product.setCategory(null);
//            product.setDiscount(null);
//            product.setManufacturer(null);
//            if (productDTO.getDiscountDTO()!=null)
//            {
//                Discount discount =product.getDiscount();
////                discount.setId(productDTO.getDiscountDTO().getId());
////                discount.setDescription(productDTO.getDiscountDTO().getDescription());
////                discount.setDiscountPer(productDTO.getDiscountDTO().getDiscount_per());
////                discount.setCode(productDTO.getDiscountDTO().getCode());
////                discount.setStartDate(productDTO.getDiscountDTO().getStart_date());
////                discount.setEndDate(productDTO.getDiscountDTO().getEnd_date());
//
//                product.setDiscount(discount);
//            }else
//            {
//                Discount discount = new Discount();
//                discount.setId(-1);
//                discount.setDescription("null");
//                discount.setDiscountPer((byte)0);
//                discount.setCode("null");
//                discount.setStartDate(null);
//                discount.setEndDate(null);
//
//                product.setDiscount(discount);
//            }
//
//            if (productDTO.getManufacturerDTO()!=null)
//            {
//                Manufacturer manufacturer = new Manufacturer();
//                manufacturer.setId(productDTO.getManufacturerDTO().getId());
//                manufacturer.setName(productDTO.getManufacturerDTO().getName());
//
//
//                product.setManufacturer(manufacturer);
//            }else
//            {
//                Manufacturer manufacturer = new Manufacturer();
//                manufacturer.setId(-1);
//                manufacturer.setName("null");
//
//
//                product.setManufacturer(manufacturer);
//            }
//
//            if (productDTO.getCategoryDTO()!=null)
//            {
//                Category category = new Category();
//                category.setId(productDTO.getCategoryDTO().getId());
//                category.setName(productDTO.getCategoryDTO().getName());
//
//                product.setCategory(category);
//            }else
//            {
//                Category category = new Category();
//                category.setId(-1);
//                category.setName("null");
//
//                product.setCategory(category);
//            }
            productRepository.save(product);

        }else
        {
            Product newProduct = new Product();

            newProduct.setName(productDTO.getName());
            newProduct.setOriginPrice(productDTO.getPrice_origin());
            newProduct.setDiscountPrice(productDTO.getPrice_discount());
            newProduct.setInventory(productDTO.getInventory());
            newProduct.setSoldQty(productDTO.getSold_qty());
            newProduct.setDescription(productDTO.getDescription());
//            newProduct.setCategory(null);
//            newProduct.setDiscount(null);
//            newProduct.setManufacturer(null);

            productRepository.save(newProduct);

        }
        return true ;
    }

    @Override
    public boolean insertProduct(ProductDTO productDTO) {
        Product product = new Product() ;


        product.setName(productDTO.getName());
        product.setOriginPrice(productDTO.getPrice_origin());
        product.setDiscountPrice(productDTO.getPrice_discount());
        product.setInventory(productDTO.getInventory());
        product.setSoldQty(productDTO.getSold_qty());
        product.setDescription(productDTO.getDescription());
        product.setCreate_date(productDTO.getCreate_date());
        product.setView_qty(productDTO.getView_qty());
        product.setDiscount_per(productDTO.getDiscount_per());


        /*Manufacturer manufacturer= new Manufacturer();
        if (productDTO.getManufacturerDTO()==null)
        {
            manufacturer.setId(-1);
            manufacturer.setName("null");

        }else
        {
            manufacturer.setId(productDTO.getManufacturerDTO().getId());
            manufacturer.setName(productDTO.getManufacturerDTO().getName());
        }*/


        Category category = new Category();
        if (productDTO.getCategoryDTO()==null)
        {
            category.setId(-1);
            category.setName("null");
        }else
        {
            category.setId(productDTO.getCategoryDTO().getId());
            category.setName(productDTO.getCategoryDTO().getName());
        }

        //product.setManufacturer(manufacturer);
        product.setCategory(category);

        productRepository.save(product);
        return true ;
    }
}
