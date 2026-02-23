package com.sample.service;

import com.sample.entity.Portfolio;
import com.sample.repository.PortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PortfolioService {

    @Autowired
    private PortfolioRepository portfolioRepository;

    public List<Portfolio> getAllPortfolios() {
        return portfolioRepository.findAll();
    }

    public Optional<Portfolio> getPortfolioById(Long id) {
        return portfolioRepository.findById(id);
    }

    public Portfolio createPortfolio(Portfolio portfolio) {
        return portfolioRepository.save(portfolio);
    }

    public Portfolio updatePortfolio(Long id, Portfolio portfolioDetails) {
        Portfolio portfolio = portfolioRepository.findById(id).orElseThrow(() -> new RuntimeException("Portfolio not found"));
        portfolio.setName(portfolioDetails.getName());
        return portfolioRepository.save(portfolio);
    }

    public void deletePortfolio(Long id) {
        Portfolio portfolio = portfolioRepository.findById(id).orElseThrow(() -> new RuntimeException("Portfolio not found"));
        portfolioRepository.delete(portfolio);
    }
}
